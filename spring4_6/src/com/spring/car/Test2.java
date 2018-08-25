package com.spring.car;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import com.spring.util.SpringUtil;

public class Test2 {

	ApplicationContext ac;

	@Before
	public void init() {
		ac = SpringUtil.getApplicationContext();
	}

	@Test
	public void testZoo() {
		CarFactory carFactory = (CarFactory) ac.getBean("carFactory");
		System.out.println(carFactory);
	}
}
