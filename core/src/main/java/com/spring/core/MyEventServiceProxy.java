package com.spring.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class MyEventServiceProxy implements EventService {

	@Autowired
	MyEventService myEventService;

	@Override
	public void create() {
		long begin = System.currentTimeMillis();
		myEventService.create();
		System.out.println(System.currentTimeMillis() - begin);
	}

	@Override
	public void delete() {
		long begin = System.currentTimeMillis();
		myEventService.delete();
		System.out.println(System.currentTimeMillis() - begin);
	}
}
