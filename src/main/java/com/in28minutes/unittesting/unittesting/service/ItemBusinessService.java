package com.in28minutes.unittesting.unittesting.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in28minutes.unittesting.unittesting.data.ItemRepository;
import com.in28minutes.unittesting.unittesting.model.Item;

@Service()
public class ItemBusinessService {

	@Autowired
	private ItemRepository repository;

	public Item retrievehardCodedItem() {
		return new Item(1, "Ball", 10, 100);
	}

	public List<Item> retrieveAllItems() {
		return repository.findAll();
	}

}
