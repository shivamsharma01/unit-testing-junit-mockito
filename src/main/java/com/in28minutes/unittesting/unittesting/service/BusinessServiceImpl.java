package com.in28minutes.unittesting.unittesting.service;

import com.in28minutes.unittesting.unittesting.data.SomeDataService;

public class BusinessServiceImpl {
	private SomeDataService someDataService;
	
	public int calculateSum(int[] data) {
		int sum = 0;
		for(int elem: data) {
			sum += elem;
		}
		return sum;
	}
	
	public int calculateSumUsingDataService() {
		int sum = 0;
		int[] data = this.someDataService.retrieveAllData();
		for(int elem: data) {
			sum += elem;
		}
		return sum;
	}

	public void setSomeDataService(SomeDataService someDataService) {
		this.someDataService = someDataService;
	}
	
	
	
}
