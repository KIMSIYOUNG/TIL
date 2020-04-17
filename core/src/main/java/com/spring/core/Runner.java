package com.spring.core;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class Runner implements ApplicationRunner {

	@Autowired
	ApplicationContext context;

	@Autowired
	MyBookRepository myBookRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Environment environment = context.getEnvironment();
		System.out.println(Arrays.toString(environment.getActiveProfiles()));
		System.out.println(Arrays.toString(environment.getDefaultProfiles()));
		System.out.println(myBookRepository);
	}
}
