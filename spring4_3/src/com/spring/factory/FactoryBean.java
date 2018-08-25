package com.spring.factory;

import com.spring.beans.Car;

public class FactoryBean implements org.springframework.beans.factory.FactoryBean<Object> {

	@Override
	public Object getObject() throws Exception {
		Car car_01 = new Car();
		car_01.setType("BMW");
		car_01.setFactory("wojia");
		car_01.setPrice(66666.00D);
		return car_01;
	}

	@Override
	public Class<Car> getObjectType() {
		return Car.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

}
