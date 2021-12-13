package gr.codelearn.spring.showcase.core.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Bike implements Vehicle {

	private final Logger logger = LoggerFactory.getLogger(Bike.class);

	private final Engine engine;

	public Bike(@Autowired Engine engine) {
		this.engine = engine;
	}

	@Override
	public void start() {
		logger.info("Travelling by Bike");
		engine.ignite();
	}
}
