package com.spring.core;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EventHandler {
	
	@EventListener
	public void handle(MyEvent myEvent) {
		System.out.println(myEvent.getData());
		System.out.println(myEvent.getSource());
	}
}
