package com.spring.car;

import org.springframework.stereotype.Component;

@Component
public class BMWCar implements ICar {

	@Override
	public String getCarName() {
		return "BMW";
	}

}
