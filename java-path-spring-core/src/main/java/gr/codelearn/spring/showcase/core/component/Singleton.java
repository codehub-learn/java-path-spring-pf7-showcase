package gr.codelearn.spring.showcase.core.component;

import gr.codelearn.spring.showcase.core.base.AbstractLogComponent;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Simple class representing a singleton object.
 */
@Component
@Scope("singleton") // default value
public class Singleton extends AbstractLogComponent {

	private int value = 0;

	public void increaseValueByOne() {
		logger.info("Singleton bean's object reference is {}", this);
		logger.info("Increasing bean's value from {} to {}.", value, ++value);
	}
}
