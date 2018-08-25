package com.spring.proxy;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
// @Order(0)
public class ValidateAspect implements Ordered {

	public ValidateAspect() {

	}

	@Before("execution(public * com.spring.proxy.ComputerImp.*(..))")
	public void validate() {
		System.out.println("调用了切面ValidateAspect的前置通知");
	}

	@Override
	public int getOrder() {
		return 0;
	}
}
