package gr.codelearn.spring.showcase.core.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties(prefix = "myproperties")
@Data
public class MappedConfigurationProperties {
	private int threadPool;
	private String email;
	private List<String> servers;
}
