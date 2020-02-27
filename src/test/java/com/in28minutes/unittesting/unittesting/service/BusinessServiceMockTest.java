package com.in28minutes.unittesting.unittesting.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.in28minutes.unittesting.unittesting.data.SomeDataService;

public class BusinessServiceMockTest {
	
	BusinessServiceImpl impl = new BusinessServiceImpl();
	SomeDataService dataService = mock(SomeDataService.class);
	
	@BeforeEach
	public void before() {
		impl.setSomeDataService(dataService);
	}
	
	@Test
	public void calculateSumUsingDataService_Basic() {
		when(dataService.retrieveAllData()).thenReturn(new int[] { 1, 2, 3 });
		int actualResult = impl.calculateSumUsingDataService();
		assertEquals(6, actualResult);
	}

	@Test
	public void calculateSumEmpty() {
		when(dataService.retrieveAllData()).thenReturn(new int[] {});
		int actualResult = impl.calculateSumUsingDataService();
		assertEquals(0, actualResult);
	}

	@Test
	public void calculateSumOneValue() {
		when(dataService.retrieveAllData()).thenReturn(new int[] { 5 });
		int actualResult = impl.calculateSumUsingDataService();
		assertEquals(5, actualResult);
	}

}
