package gr.codelearn.spring.showcase.core.bootstrap;

import gr.codelearn.spring.showcase.core.base.AbstractLogComponent;
import gr.codelearn.spring.showcase.core.component.Prototype;
import gr.codelearn.spring.showcase.core.component.Singleton;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Bootstrap class demonstrating Spring beans scopes. It runs only once during
 * application initialization due to implementing ApplicationRunner interface.
 */
@Component
@RequiredArgsConstructor
public class ScopeRunner extends AbstractLogComponent implements ApplicationRunner {
	private final ApplicationContext appContext;

	@Override
	public void run(final ApplicationArguments args) throws Exception {
		logger.debug("Loading some instances from a singleton scoped bean.");
		var s1 = appContext.getBean(Singleton.class);
		s1.increaseValueByOne();
		var s2 = appContext.getBean(Singleton.class);
		s2.increaseValueByOne();
		var s3 = appContext.getBean(Singleton.class);
		s3.increaseValueByOne();

		logger.debug("Loading some instances from a prototype scoped bean.");
		var p1 = appContext.getBean(Prototype.class);
		p1.increaseValueByOne();
		var p2 = appContext.getBean(Prototype.class);
		p2.increaseValueByOne();
		var p3 = appContext.getBean(Prototype.class);
		p3.increaseValueByOne();
	}
}
