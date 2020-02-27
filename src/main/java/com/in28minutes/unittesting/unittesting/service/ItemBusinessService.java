package com.in28minutes.unittesting.unittesting.service;

import org.springframework.stereotype.Service;

import com.in28minutes.unittesting.unittesting.model.Item;

@Service()
public class ItemBusinessService {

	public Item retrievehardCodedItem() {
		return new Item(1, "Ball", 10, 100);
	}
	
}
