package com.spring.core;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {

	@GetMapping("/event/{event}")
	public String mapping(@PathVariable Event event) {
		System.out.println(event.toString());
		return event.getId().toString();
	}
}
