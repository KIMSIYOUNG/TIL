package com.spring.core;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerfAspect {

	// @Around("execution(* com.spring.core..*.*(..))")
	@Around("@annotation(PerfLogging)")
	public Object logPerf(ProceedingJoinPoint point) throws Throwable {
		long begin = System.currentTimeMillis();
		Object proceed = point.proceed();
		System.out.println(System.currentTimeMillis() - begin);
		return proceed;
	}

	@Before("bean(myEventService)")
	public void hello() {
		System.out.println("hello");
	}
}
