package gr.codelearn.spring.showcase.core.config;

import gr.codelearn.spring.showcase.core.domain.Bike;
import gr.codelearn.spring.showcase.core.domain.Car;
import gr.codelearn.spring.showcase.core.domain.Engine;
import gr.codelearn.spring.showcase.core.domain.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VehicleConfig {

	@Autowired
	Engine engine;

	@Bean
	public Vehicle toyotaYaris(){
		return new Car("Toyota");
	}

	@Bean
	public Vehicle renaultClio(){
		return new Car("Renault");
	}

	@Bean(name = "car")
	public Car getCar() {
		return new Car("some car");
	}

	@Bean(name = "suzukiVstrom")
	public Bike getBike() {
		return new Bike(engine);
	}

}
