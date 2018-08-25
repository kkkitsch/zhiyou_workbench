package com.spring.beans;

public class Car {
	private String type;
	private String factory;
	private double price;

	public Car() {
		System.out.println("构造方法执行中......创建车......");
	}

	public Car(String type, String factory, double price) {
		super();
		this.type = type;
		this.factory = factory;
		this.price = price;
	}

	public String getFactory() {
		return factory;
	}

	public String getType() {
		return type;
	}

	public void setFactory(String factory) {
		this.factory = factory;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Car [type=" + type + ", factory=" + factory + ", price=" + price + "]";
	}

}
