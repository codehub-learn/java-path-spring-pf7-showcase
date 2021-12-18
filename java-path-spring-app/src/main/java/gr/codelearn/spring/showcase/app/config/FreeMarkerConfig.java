package gr.codelearn.spring.showcase.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

/**
 * This class mainly configures the template engine (Freemarker) that is used for the html presentation/parsing.
 */
@Configuration
public class FreeMarkerConfig {
	@Bean
	public FreeMarkerViewResolver freemarkerViewResolver() {
		// Helps in mapping view names to actual views
		FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
		resolver.setCache(true);
		resolver.setPrefix("");
		resolver.setSuffix(".ftl");
		return resolver;
	}

	@Bean
	public FreeMarkerConfigurer freemarkerConfig() {
		// Setting custom location for our templates
		FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
		freeMarkerConfigurer.setTemplateLoaderPath("classpath:/freemarker");
		return freeMarkerConfigurer;
	}
}
