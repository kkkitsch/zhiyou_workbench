package com.spring.test;

import java.text.DateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

import com.spring.beans.Car;
import com.spring.beans.Person;
import com.spring.util.SpringUtil;

public class TestIoC {

	ApplicationContext ac;

	@Before
	public void init() {
		ac = SpringUtil.getApplicationContext();
	}

	@Test
	public void setListProperty() {
		System.out.println(ac.getBean("person_01", Person.class));
		System.out.println(ac.getBean("person_02", Person.class));
		System.out.println(ac.getBean("person_03", Person.class));
		System.out.println(ac.getBean("person_05", Person.class));
		System.out.println(ac.getBean("person_06", Person.class));
		System.out.println(ac.getBean("person_07", Person.class));
	}

	@Test
	public void testDateFormat() {
		System.out.println(ac.getBean("dateFormat", DateFormat.class));
	}

	@Test
	public void testSimpleDateFormat() {
		System.out.println((Date) ac.getBean("date"));
	}

	@Test
	public void testFactoryBean() {
		System.out.println((Car) ac.getBean("factoryBean"));
	}

}
