package com.spring.beans;

import org.springframework.stereotype.Component;

@Component(value = "kitsch")
public class Person {

	public Person() {
		System.out.println("无参构造......");
	}

	public void eat() {
		System.out.println("正在吃饭......");
	}

}
