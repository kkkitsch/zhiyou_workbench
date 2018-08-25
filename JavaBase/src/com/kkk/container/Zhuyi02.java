package com.kkk.container;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class Zhuyi02 {
	@Test
	public void test() {
		Map<String, Wife> map = new HashMap<String, Wife>();
		map.put("刘利合", new Wife("张曼玉"));
		map.put("陈二狗", new Wife("胡铁花"));
		// 把"陈二狗"这个地址给了w
		Wife w = map.get("陈二狗");
		// 移除并不是删除，w中还有地址
		map.remove("陈二狗");
		System.out.println(w);
	}
}

class Wife {

	String name;

	public Wife() {
	}

	public Wife(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Wife [name=" + name + "]";
	}
}