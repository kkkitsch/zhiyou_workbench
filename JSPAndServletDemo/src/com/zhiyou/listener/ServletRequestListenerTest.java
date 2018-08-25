package com.zhiyou.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener(value = "")
public class ServletRequestListenerTest implements ServletRequestListener {

	public ServletRequestListenerTest() {
		System.out.println("ServletRequestListenerTest 构造方法......");
	}

	public void requestInitialized(ServletRequestEvent event) {
		System.out.println("ServletRequestListener requestInitialized......");
	}

	public void requestDestroyed(ServletRequestEvent event) {
		System.out.println("ServletRequestListener requestDestroyed......");
	}

}
