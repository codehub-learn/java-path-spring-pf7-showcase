package gr.codelearn.spring.showcase.core.domain;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile({"diesel", "default"})
@Component
public class DieselEngine implements Engine {

	private final Logger logger = LoggerFactory.getLogger(DieselEngine.class);

	@Override
	public void ignite() {
		logger.info("Starting Diesel Engine");
	}
}
