package gr.codelearn.spring.showcase.app.config;

import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class ProductFilterConfiguration {
	private static final Set<String> ignoredFields = new HashSet<>();

	static {
		ignoredFields.add("id");
	}

	@Bean
	public Jackson2ObjectMapperBuilderCustomizer productCustomizer(){
		SimpleFilterProvider simpleFilterProvider = new SimpleFilterProvider();
		SimpleFilterProvider filters = simpleFilterProvider.addFilter("product_filter",
																	  SimpleBeanPropertyFilter.serializeAllExcept(ignoredFields));

		// The old way (prior to Java 8)
//		return new Jackson2ObjectMapperBuilderCustomizer() {
//			@Override
//			public void customize(final Jackson2ObjectMapperBuilder jacksonObjectMapperBuilder) {
//				jacksonObjectMapperBuilder.filters(filters);
//			}
//		};
		// The new way (through lambda)
		return jacksonObjectMapperBuilder -> jacksonObjectMapperBuilder.filters(filters);
	}
}
