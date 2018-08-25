package com.spring.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringUtil {

	public static ApplicationContext getApplicationContext() {
		return new ClassPathXmlApplicationContext("applicationContext.xml");
	}

}
