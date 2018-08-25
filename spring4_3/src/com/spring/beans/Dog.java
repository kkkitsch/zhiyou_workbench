package com.spring.beans;

public class Dog {

	private String type;

	public Dog() {
		System.out.println("创建了一个Dog......");
	}

	public Dog(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Dog [type=" + type + "]";
	}
}
