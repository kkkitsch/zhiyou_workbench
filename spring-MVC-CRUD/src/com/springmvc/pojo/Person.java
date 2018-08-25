package com.springmvc.pojo;

public class Person {

	private String name;
	private Integer age;

	public Person() {
	}

	public Integer getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

}
