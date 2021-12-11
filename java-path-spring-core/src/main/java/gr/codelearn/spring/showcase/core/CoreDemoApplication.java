package gr.codelearn.spring.showcase.core;

import gr.codelearn.spring.showcase.core.service.TravelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CoreDemoApplication {

	//remember to perform a clean after adding logging configuration, before executing class
	private static final Logger logger = LoggerFactory.getLogger(CoreDemoApplication.class);

	public static void main(String[] args) {

		logger.info("Starting program execution");
		TravelService myTravel = new TravelService();
		myTravel.startJourney();
	}
}
