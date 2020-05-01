package com.spring.jpa;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {
	
	@Test
	void moveTest() {
		Car car = new Car(3) {
			@Override
			protected int randomInt() {
				return 5;
			}
		};
		car.move();
		assertThat(car.getPosition()).isEqualTo(4);
	}

	@Test
	void notMoveTest() {
		final Car car = new Car(3) {
			@Override
			protected int randomInt() {
				return 3;
			}
		};
		car.move();
		assertThat(car.getPosition()).isEqualTo(3);
	}
}