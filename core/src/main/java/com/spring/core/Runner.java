package com.spring.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Runner implements ApplicationRunner {

	@Autowired
	ApplicationContext context;

	@Autowired
	Single single;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println(context.getBean(Proto.class));
		System.out.println(context.getBean(Proto.class));
		System.out.println(context.getBean(Proto.class));

		System.out.println(context.getBean(Single.class));
		System.out.println(context.getBean(Single.class));
		System.out.println(context.getBean(Single.class));

		System.out.println(single.getProto());
		System.out.println(single.getProto());
		System.out.println(single.getProto());
	}
}
