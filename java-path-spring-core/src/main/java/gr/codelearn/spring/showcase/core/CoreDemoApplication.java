package gr.codelearn.spring.showcase.core;

import gr.codelearn.spring.showcase.core.domain.Bike;
import gr.codelearn.spring.showcase.core.domain.Car;
import gr.codelearn.spring.showcase.core.domain.Vehicle;
import gr.codelearn.spring.showcase.core.service.TravelService;
import gr.codelearn.spring.showcase.core.service.TravelServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CoreDemoApplication {

	//remember to perform a clean after adding/changing logging configuration, before executing class
	private static final Logger logger = LoggerFactory.getLogger(CoreDemoApplication.class);

	public static void main(String[] args) {
		logger.info("Starting program execution");

		ApplicationContext ctx = SpringApplication.run(CoreDemoApplication.class, args);

		Vehicle vehicle = ctx.getBean("renaultClio", Car.class);
		TravelServiceImpl myTravel = new TravelServiceImpl(vehicle);
		myTravel.startJourney();

		vehicle = ctx.getBean("toyotaYaris", Car.class);
		TravelServiceImpl anotherTravel = new TravelServiceImpl(vehicle);
		anotherTravel.startJourney();

		// this bean is still being picked up, although annotated with @Component, due to @SpringBootApplication 
		// ComponentScanning
		vehicle = ctx.getBean("bike", Bike.class);
		TravelServiceImpl additionalTravel = new TravelServiceImpl(vehicle);
		additionalTravel.startJourney();


		//The following beans are coming from @Configuration annotated classes

		//DI with constructor
		TravelService carTravelService = ctx.getBean("carTravelService", TravelService.class);
		carTravelService.startJourney();

		//DI with setter
		TravelService bikeTravelService = ctx.getBean("bikeTravelService", TravelService.class);
		bikeTravelService.startJourney();

		//DI with Autowired
		TravelService travelService = ctx.getBean("autowiredInjectedTravel", TravelService.class);
		travelService.startJourney();

	}
}
