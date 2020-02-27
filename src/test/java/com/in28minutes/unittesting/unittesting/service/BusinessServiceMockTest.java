package com.in28minutes.unittesting.unittesting.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.in28minutes.unittesting.unittesting.data.SomeDataService;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class BusinessServiceMockTest {
	@InjectMocks
	BusinessServiceImpl impl = new BusinessServiceImpl();

	@Mock
	SomeDataService dataService;

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
