package com.spring.annotation;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import com.spring.util.SpringUtil;

public class Test1 {

	ApplicationContext ac;

	@Before
	public void init() {
		ac = SpringUtil.getApplicationContext();
	}

	@Test
	public void testZoo() {
		Zoo zoo = (Zoo) ac.getBean("zoo");
		System.out.println(zoo);
	}
}
