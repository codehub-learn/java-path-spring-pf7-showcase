package gr.codelearn.spring.showcase.core.bootstrap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Bootstrap class demonstrating the property retrieval from two distinctive sources. It runs only once during
 * application initialization.
 */
@Component
public class SampleRunner implements CommandLineRunner {

	private final Logger logger = LoggerFactory.getLogger(SampleRunner.class);

	@Value("${spring.application.name}")
	private String applicationName;

	@Value("${server.port}")
	private String serverPort;

	@Value("${custom.property}")
	private String customProperty;

	@Value("${default.example:default}")
	private String defaultValueExample;

	@Override
	public void run(final String... args) throws Exception {
		logger.info("Application named '{}' is being started at port {} " +
							"has a custom property having the value of '{}' " +
							"as well as a property getting a default value '{}' ", applicationName, serverPort,
					customProperty, defaultValueExample);
	}
}
