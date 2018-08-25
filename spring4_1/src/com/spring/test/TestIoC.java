package com.spring.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

import com.spring.beans.Car;
import com.spring.beans.Dog;
import com.spring.beans.Person;
import com.spring.util.SpringUtil;

public class TestIoC {

	ApplicationContext ac;

	@Before
	public void init() {
		ac = SpringUtil.getApplicationContext();
	}

	
	
	// 使用IoC方式创建对象
	@Test
	public void testIoC_01() {
		System.out.println((Person) ac.getBean("person_05"));
	}

	
	
	// 使用IoC方式创建对象，没有重写toString()方法
	@Test
	public void testIoC_02() {
		System.out.println((Dog) ac.getBean("dog_01"));
	}

	
	
	// 使用IoC方式创建对象，spring配置文件中bean没有指定id值
	@Test
	public void testIoC_03() {
		System.out.println((Dog) ac.getBean("com.spring.beans.Dog"));
	}

	
	
	// 获取bean的三种方法
	@Test
	public void getBean() {

		// System.out.println((Dog) ac.getBean("dog_01"));

		// System.out.println(ac.getBean(Dog.class));

		System.out.println(ac.getBean("dog_01", Dog.class));
	}

	
	
	// 测试通过构造器进行属性注入
	@Test
	public void setPropertyByConstructor_01() {
		System.out.println(ac.getBean("dog_02", Dog.class));
	}
	@Test
	public void setPropertyByConstructor_02() {
		System.out.println(ac.getBean("car_01", Car.class));
	}

	
	
	// 使用传统方法创建对象
	public void traditional() {
		Person p = new Person();
		p.setName("kk");
		p.setAge(21);
	}

}
