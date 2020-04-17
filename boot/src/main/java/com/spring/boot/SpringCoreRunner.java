package com.spring.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.spring.core.SpringCore;

@Component
public class SpringCoreRunner implements ApplicationRunner {

	@Autowired
	SpringCore springCore;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println(springCore);
	}
}
