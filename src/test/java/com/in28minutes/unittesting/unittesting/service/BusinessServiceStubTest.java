package com.in28minutes.unittesting.unittesting.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.in28minutes.unittesting.unittesting.data.SomeDataService;

class SomeDataServiceBasicStub implements SomeDataService {

	@Override
	public int[] retrieveAllData() {
		return new int[] { 1, 2, 3 };
	}

}

class SomeDataServiceEmptyStub implements SomeDataService {

	@Override
	public int[] retrieveAllData() {
		return new int[] {};
	}

}

class SomeDataServiceOneValueStub implements SomeDataService {

	@Override
	public int[] retrieveAllData() {
		return new int[] { 5 };
	}

}

public class BusinessServiceStubTest {
	@Test
	public void calculateSumUsingDataService_Basic() {
		BusinessServiceImpl impl = new BusinessServiceImpl();
		impl.setSomeDataService(new SomeDataServiceBasicStub());
		int actualResult = impl.calculateSumUsingDataService();
		int expectedResult = 6;
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void calculateSumEmpty() {
		BusinessServiceImpl impl = new BusinessServiceImpl();
		impl.setSomeDataService(new SomeDataServiceEmptyStub());
		int actualResult = impl.calculateSumUsingDataService();
		int expectedResult = 0;
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void calculateSumOneValue() {
		BusinessServiceImpl impl = new BusinessServiceImpl();
		impl.setSomeDataService(new SomeDataServiceOneValueStub());
		int actualResult = impl.calculateSumUsingDataService();
		int expectedResult = 5;
		assertEquals(expectedResult, actualResult);
	}
}
