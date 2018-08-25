package com.spring.annotation;

import org.springframework.stereotype.Component;

@Component
public class Monkey {

	private String monkeyName;

	@Override
	public String toString() {
		return "Monkey [monkeyName=" + monkeyName + "]";
	}
}
