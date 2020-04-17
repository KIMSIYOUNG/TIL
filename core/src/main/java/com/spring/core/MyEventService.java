package com.spring.core;

import org.springframework.stereotype.Service;

@Service
public class MyEventService implements EventService {
	@Override
	public void create() {
		System.out.println("created");
	}

	@Override
	public void delete() {
		System.out.println("deleted");
	}
}
