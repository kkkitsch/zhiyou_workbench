package com.zhiyou.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class HttpSessionListenerTest implements HttpSessionListener {

	public HttpSessionListenerTest() {
		System.out.println("HttpSessionListenerTest 构造方法......");
	}

	public void sessionCreated(HttpSessionEvent event) {
		System.out.println("HttpSessionListener sessionCreated......");
	}

	public void sessionDestroyed(HttpSessionEvent event) {
		System.out.println("HttpSessionListener sessionDestroyed......");
	}

}
