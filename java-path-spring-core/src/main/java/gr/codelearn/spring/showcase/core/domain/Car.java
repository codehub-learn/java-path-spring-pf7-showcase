package gr.codelearn.spring.showcase.core.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Car implements Vehicle {

	private final Logger logger = LoggerFactory.getLogger(Car.class);

	private final String make;

	public Car(final String make) {
		this.make = make;
	}

	@Override
	public void start() {
		logger.info("Travelling by Car, make: {}", make);
	}
}
