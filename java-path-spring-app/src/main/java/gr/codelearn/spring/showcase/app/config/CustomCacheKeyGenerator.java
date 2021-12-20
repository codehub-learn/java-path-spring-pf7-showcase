package gr.codelearn.spring.showcase.app.config;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;

public class CustomCacheKeyGenerator implements KeyGenerator {
	@Override
	public Object generate(final Object target, final Method method, final Object... params) {
		return target.getClass().getSimpleName() + "_" + method.getName() + "_" + StringUtils.arrayToDelimitedString(
				params, "_");
	}
}
