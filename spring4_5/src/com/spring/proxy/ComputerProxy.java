package com.spring.proxy;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

public class ComputerProxy {
	// 即将被代理的对象
	private Computer computer;

	public ComputerProxy(Computer computer) {
		this.computer = computer;
	}

	// 已经被代理的对象
	public Computer getComputerProxy() {
		ClassLoader loader = Computer.class.getClassLoader();
		Class[] interfaces = { Computer.class };
		InvocationHandler h = new InvocationHandler() {
			// proxy ：代理对象
			// method :代理对象中的方法
			// args:方法参数
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println("正在 进行" + method.getName() + "方法操作");
				// 执行被代理对象的方法
				Object o = method.invoke(computer, args);
				System.out.println("结束" + method.getName() + "方法操作");
				return o;
			}
		};
		Computer com = (Computer) Proxy.newProxyInstance(loader, interfaces, h);
		return com;
	}
}
