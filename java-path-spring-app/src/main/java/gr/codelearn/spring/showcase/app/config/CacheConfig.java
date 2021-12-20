package gr.codelearn.spring.showcase.app.config;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CacheConfig extends CachingConfigurerSupport {
	@Bean("customCacheKeyGenerator")
	public KeyGenerator keyGenerator() {
		return new CustomCacheKeyGenerator();
	}
}
