package com.in28minutes.unittesting.unittesting.service;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.never;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

public class ListMockTest {
	List<String> mock = mock(List.class);

	@Test
	public void size_basic() {
		when(mock.size()).thenReturn(5);
		assertEquals(5, mock.size());
	}

	@Test
	public void returnDifferentValues() {
		when(mock.size()).thenReturn(5).thenReturn(10);
		assertEquals(5, mock.size());
		assertEquals(10, mock.size());
	}

	@Test
	public void returnWithParameters() {
		when(mock.get(0)).thenReturn("in28Minutes");
		assertEquals("in28Minutes", mock.get(0));
		assertEquals(null, mock.get(1));
	}

	@Test
	public void returnWithGenericParameters() {
		when(mock.get(anyInt())).thenReturn("in28Minutes");
		assertEquals("in28Minutes", mock.get(0));
		assertEquals("in28Minutes", mock.get(1));
	}

	// check internal method invocations by the class we are testing
	@Test
	public void verificationBasics() {
		String value1 = mock.get(0);
		String value2 = mock.get(1);
		
		verify(mock).get(0);
		verify(mock, times(2)).get(anyInt());
		verify(mock, atLeast(1)).get(anyInt());
					//or
		verify(mock, atLeastOnce()).get(anyInt());
		
		verify(mock, atMost(2)).get(anyInt());
		verify(mock, never()).get(2);
	}

	// check value passed to internal method by the class we are testing
		@Test
		public void argumentCapturing() {
			mock.add("SomeString");
			
			ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
			verify(mock).add(captor.capture());
			assertEquals("SomeString", captor.getValue());
		}
		
		// check multiple values passed to internal method by the class we are testing
		@Test
		public void multipleArgumentCapturing() {
			mock.add("SomeString1");
			mock.add("SomeString2");
			
			ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
			verify(mock, times(2)).add(captor.capture());
			List<String> allValues = captor.getAllValues();
			assertEquals("SomeString1", allValues.get(0));
			assertEquals("SomeString2", allValues.get(1));
		}

		// mock does not retain any behavior
		@Test
		public void checkMock() {
			ArrayList listMock = mock(ArrayList.class);
			// returns null instead of exception
			System.out.println(listMock.get(0));
			
			listMock.add("Test");
			// still null
			System.out.println(listMock.get(0));
			
			// 0 instead of 1
			System.out.println(listMock.size());
			
			when(listMock.size()).thenReturn(5);
			// now returns 5
			System.out.println(listMock.size());
		}
		
		// spy uses the original class and only changes behaviors of those mentioned ex using when
		@Test
		public void checkSpy() {
			ArrayList listSpy = spy(ArrayList.class);
			// exception
			try {
				System.out.println(listSpy.get(0));
			} catch (Exception e) {
				System.out.println(e);
			}
			
			listSpy.add("Test");
			// Test
			System.out.println(listSpy.get(0));
			
			//  1
			System.out.println(listSpy.size());
			
			when(listSpy.size()).thenReturn(5);
			// now returns 5
			System.out.println(listSpy.size());
		}
		
}
