package com.spring.core;

import org.springframework.stereotype.Service;

@Service
public class MyEventService implements EventService {
	@PerfLogging
	@Override
	public void create() {
		System.out.println("created");
	}

	@PerfLogging
	@Override
	public void delete() {
		System.out.println("deleted");
	}
}
