package com.zhiyou.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ServletContextListenerTest implements ServletContextListener {

	public ServletContextListenerTest() {
		System.out.println("ServletContextListenerTest 构造方法......");
	}

	public void contextInitialized(ServletContextEvent event) {
		System.out.println("ServletContextListener 初始化......");
	}

	public void contextDestroyed(ServletContextEvent event) {
		System.out.println("ServletContextListener 销毁......");
	}
}
