package com.spring.proxy;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

import com.spring.util.SpringUtil;

public class Test3 {

	ApplicationContext ac;

	@Before
	public void init() {
		ac = SpringUtil.getApplicationContext();
	}

	// 测试使用AOP进行代理
	@Test
	public void testAOP() {
		Computer computer = (Computer) ac.getBean("computerImp");
		int result = computer.div(6, 2);
		System.out.println(result);
	}
}
