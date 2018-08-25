package com.zhiyou.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ServletRequestAttributeListenerTest implements ServletRequestAttributeListener {

	public ServletRequestAttributeListenerTest() {
		System.out.println("ServletRequestAttributeListenerTest 构造方法......");
	}

	public void attributeAdded(ServletRequestAttributeEvent event) {
		System.out.println("ServletRequestAttributeListener  attributeAdded......");
	}

	public void attributeReplaced(ServletRequestAttributeEvent event) {
		System.out.println("ServletRequestAttributeListener attributeReplaced......");
	}

	public void attributeRemoved(ServletRequestAttributeEvent event) {
		System.out.println("ServletRequestAttributeListener  attributeRemoved......");
	}

}
