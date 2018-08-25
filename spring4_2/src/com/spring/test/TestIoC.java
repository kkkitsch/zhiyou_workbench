package com.spring.test;

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
	public void getPerson() {
		System.out.println(ac.getBean("person_01", Person.class));
		System.out.println(ac.getBean("person_02", Person.class));
		System.out.println(ac.getBean("person_03", Person.class));
		System.out.println(ac.getBean("person_05", Person.class));
		System.out.println(ac.getBean("person_06", Person.class));
	}

	@Test
	public void testBeanScope_Singleton() {
		Car car_01 = ac.getBean("car_01", Car.class);
		Car car_02 = ac.getBean("car_01", Car.class);
		System.out.println(car_01 == car_02);
	}

	@Test
	public void testBeanScope_Prototype() {
		Car car_01 = ac.getBean("car_03", Car.class);
		Car car_02 = ac.getBean("car_03", Car.class);
		System.out.println(car_01 == car_02);
	}
}
