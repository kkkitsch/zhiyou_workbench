package com.spring.car;

import org.springframework.stereotype.Component;

@Component
public class Benz implements ICar {

	@Override
	public String getCarName() {
		return "Benz";
	}

}
