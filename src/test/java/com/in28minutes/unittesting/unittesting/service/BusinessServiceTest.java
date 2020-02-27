package com.in28minutes.unittesting.unittesting.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BusinessServiceTest {

	@Test
	public void calculateSum_Basic() {
		BusinessServiceImpl impl = new BusinessServiceImpl();
		int actualResult = impl.calculateSum(new int[] { 1, 2, 3 });
		int expectedResult = 6;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void calculateSum_Empty() {
		BusinessServiceImpl impl = new BusinessServiceImpl();
		int actualResult = impl.calculateSum(new int[] {  });
		int expectedResult = 0;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void calculateSum_OneValue() {
		BusinessServiceImpl impl = new BusinessServiceImpl();
		int actualResult = impl.calculateSum(new int[] { 5 });
		int expectedResult = 5;
		assertEquals(expectedResult, actualResult);
	}
	
}
