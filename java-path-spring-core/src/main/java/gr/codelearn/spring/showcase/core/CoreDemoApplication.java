package gr.codelearn.spring.showcase.core;

import gr.codelearn.spring.showcase.core.domain.Bike;
import gr.codelearn.spring.showcase.core.domain.Car;
import gr.codelearn.spring.showcase.core.domain.Vehicle;
import gr.codelearn.spring.showcase.core.service.TravelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class CoreDemoApplication {

	//remember to perform a clean after adding/changing logging configuration, before executing class
	private static final Logger logger = LoggerFactory.getLogger(CoreDemoApplication.class);

	public static void main(String[] args) {
		logger.info("Starting program execution");

		ApplicationContext context = SpringApplication.run(CoreDemoApplication.class, args);

		Vehicle vehicle = context.getBean("beanConfiguredCar", Car.class);
		TravelService myTravel = new TravelService(vehicle);
		myTravel.startJourney();

		vehicle = context.getBean("anotherBeanConfiguredCar", Car.class);
		TravelService anotherTravel = new TravelService(vehicle);
		myTravel.startJourney();

		/* this bean is still being picked up, although annotated with @Component, due to @SpringBootApplication
		ComponentScanning */
		vehicle = context.getBean("bike", Bike.class);
		TravelService additionalTravel = new TravelService(vehicle);
		additionalTravel.startJourney();

	}
}
