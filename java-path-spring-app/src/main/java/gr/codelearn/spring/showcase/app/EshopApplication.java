package gr.codelearn.spring.showcase.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableJpaRepositories(namedQueriesLocation = "classpath:jpa-named-queries.properties")
@EnableScheduling
public class EshopApplication {
	public static void main(String[] args) {
		SpringApplication.run(EshopApplication.class, args);
	}
}
