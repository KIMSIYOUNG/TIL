package com.spring.jpa;

public class Car {
	private int position;

	public Car(int position) {
		this.position = position;
	}

	public void move() {
		if (randomInt() > 4) {
			this.position++;
		}
	}

	protected int randomInt() {
		return (int)(Math.random() * 10);
	}

	public int getPosition() {
		return position;
	}
}
