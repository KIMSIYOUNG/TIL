package com.spring.core;

public class SpringCore {
	private String name;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "SpringCore{" +
			"name='" + name + '\'' +
			'}';
	}
}
