package com.spring.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Zoo {
	
	@Autowired(required = false)
	private Tiger tiger;
	@Autowired(required = false)
	private Monkey monkey;

	public Zoo() {
	}

	@Override
	public String toString() {
		return "Zoo [tiger=" + tiger + ", monkey=" + monkey + "]";
	}

}
