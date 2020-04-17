package com.spring.core;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class EventFormatter implements Formatter<Event> {
	@Override
	public Event parse(String s, Locale locale) throws ParseException {
		return new Event(Integer.parseInt(s));
	}

	@Override
	public String print(Event event, Locale locale) {
		return event.getId().toString();
	}
}
