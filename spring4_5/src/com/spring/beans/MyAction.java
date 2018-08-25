package com.spring.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MyAction {

	@Autowired(required = false)
	private MyService service;

	public void execute() {
		System.out.println("Action中execute方法调用......");
		service.add();
	}
}
