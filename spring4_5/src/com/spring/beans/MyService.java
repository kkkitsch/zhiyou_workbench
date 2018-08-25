package com.spring.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService {

	@Autowired
	private MyDAO dao;

	public void add() {
		System.out.println("MyService当中的add方法调用......");
		dao.insert();
	}
}
