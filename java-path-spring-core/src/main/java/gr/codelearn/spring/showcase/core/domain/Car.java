package gr.codelearn.spring.showcase.core.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Car {

	private final Logger logger = LoggerFactory.getLogger(Car.class);

	public void drive() {
		logger.info("Travelling by Car");
	}

}
