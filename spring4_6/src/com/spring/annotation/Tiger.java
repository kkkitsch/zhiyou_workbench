package com.spring.annotation;

import org.springframework.stereotype.Component;

@Component
public class Tiger {

	private String tigerName;

	@Override
	public String toString() {
		return "Tiger [tigerName=" + tigerName + "]";
	}
}
