package com.spring.core;

public class MyEvent {
	private int data;
	private Object source;

	public MyEvent(int data, Object source) {
		this.data = data;
		this.source = source;
	}

	public int getData() {
		return data;
	}

	public Object getSource() {
		return source;
	}
}
