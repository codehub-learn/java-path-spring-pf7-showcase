package gr.codelearn.spring.showcase.core.component;

import gr.codelearn.spring.showcase.core.base.AbstractLogComponent;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Simple class representing a prototype object.
 */
@Component
@Scope("prototype")
public class Prototype extends AbstractLogComponent {
	private int value = 0;

	public void increaseValueByOne() {
		logger.info("Prototype bean's object reference is {}", this);
		logger.info("Increasing bean's value from {} to {}.", value, ++value);
	}
}
