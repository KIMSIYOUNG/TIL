package com.spring.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class KyleRunner implements ApplicationRunner {

	@Autowired
	KyleProperties kyleProperties;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("========================");
		System.out.println(kyleProperties.getName());
		System.out.println(kyleProperties.getAge());
		System.out.println("========================");
	}
}
