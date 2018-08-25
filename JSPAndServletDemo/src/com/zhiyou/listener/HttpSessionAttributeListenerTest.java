package com.zhiyou.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class HttpSessionAttributeListenerTest implements HttpSessionAttributeListener {

	public HttpSessionAttributeListenerTest() {
		System.out.println("HttpSessionAttributeListenerTest 构造方法......");
	}

	public void attributeAdded(HttpSessionBindingEvent event) {
		System.out.println("HttpSessionAttributeListener attributeAdded......");
	}

	public void attributeRemoved(HttpSessionBindingEvent event) {
		System.out.println("HttpSessionAttributeListener attributeRemoved......");
	}

	public void attributeReplaced(HttpSessionBindingEvent event) {
		System.out.println("HttpSessionAttributeListener attributeReplaced......");
	}

}
