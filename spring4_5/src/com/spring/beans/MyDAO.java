package com.spring.beans;

import org.springframework.stereotype.Repository;

@Repository
public class MyDAO {
	public void insert() {
		System.out.println("DAO中insert方法调用......");
	}
}
