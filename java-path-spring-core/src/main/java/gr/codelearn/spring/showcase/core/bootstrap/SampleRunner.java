package gr.codelearn.spring.showcase.core.bootstrap;

import gr.codelearn.spring.showcase.core.base.AbstractLogComponent;
import gr.codelearn.spring.showcase.core.config.MappedConfigurationProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * Bootstrap class demonstrating the property retrieval from two distinctive sources. It runs only once during
 * application initialization.
 */
@Component
@RequiredArgsConstructor
@Profile("dev")
public class SampleRunner extends AbstractLogComponent implements CommandLineRunner {
	private final MappedConfigurationProperties mappedConfigurationProperties;

	@Value("${spring.application.name}")
	private String applicationName;

	@Value("${server.port}")
	private String serverPort;

	@Value("${custom.property}")
	private String customProperty;

	@Value("${default.example:default}")
	private String defaultValueExample;

	@Value("${profile.property.example}")
	private String profilePropertyExample;

	@Override
	public void run(final String... args) throws Exception {
		logger.info("Application named '{}' is being started at port {} " +
							"has a custom property having the value of '{}' " +
							"as well as a property getting a default value '{}' " +
							"and a profile based property with value '{}' ", applicationName, serverPort,
					customProperty, defaultValueExample, profilePropertyExample);

		// Retrieves information from YAML file
		logger.info("Using yaml, current threadPool value is {}.", mappedConfigurationProperties.getThreadPool());
		logger.info("Using yaml, current email value is {}.", mappedConfigurationProperties.getEmail());
		logger.info("Using yaml, current server values are {}.", mappedConfigurationProperties.getServers());
	}
}
