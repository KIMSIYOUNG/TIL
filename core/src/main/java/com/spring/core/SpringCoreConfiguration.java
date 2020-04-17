package com.spring.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCoreConfiguration {

	@Bean
	public SpringCore springCore() {
		SpringCore spring = new SpringCore();
		spring.setName("KYLE");
		return spring;
	}
}
