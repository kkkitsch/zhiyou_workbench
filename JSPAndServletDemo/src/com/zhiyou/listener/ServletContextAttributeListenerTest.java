package com.zhiyou.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ServletContextAttributeListenerTest implements ServletContextAttributeListener {

	public ServletContextAttributeListenerTest() {
		System.out.println(" ServletContextAttributeListenerTest 构造方法......");
	}

	public void attributeAdded(ServletContextAttributeEvent event) {
		System.out.println(" ServletContextAttributeListener attributeAdded......");
	}

	public void attributeRemoved(ServletContextAttributeEvent event) {
		System.out.println(" ServletContextAttributeListener attributeRemoved......");
	}

	public void attributeReplaced(ServletContextAttributeEvent event) {
		System.out.println(" ServletContextAttributeListener attributeReplaced......");
	}

}
