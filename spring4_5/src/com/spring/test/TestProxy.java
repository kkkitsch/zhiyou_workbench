package com.spring.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

import com.spring.proxy.Computer;
import com.spring.proxy.ComputerImp;
import com.spring.proxy.ComputerProxy;
import com.spring.util.SpringUtil;

public class TestProxy {

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

	// 使用传统代理类
	@Test
	public void testProxy() {
		// 获取computer对象实例
		Computer computer = new ComputerImp();
		// 将实例传入代理类
		ComputerProxy proxy = new ComputerProxy(computer);
		// 代理后的compute实例
		computer = proxy.getComputerProxy();
		// 执行add方法之前，在代理类中执行invoke方法
		int result = computer.add(1, 2);
		System.out.println(result);
	}
}
