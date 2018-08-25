package com.kkk.reflect;

import org.junit.Test;

/*
 * 获取类实现的所有接口  类的父类
 */
public class GetInterface {
	// 获取ImpInterface类实现的接口和父类
	@Test
	public void getInterface() {
		Class<?> inter[] = null;
		try {
			inter = ImpInterface.class.getInterfaces();
			System.out.println("实现的接口：");
			for (Class<?> c : inter) {
				System.out.println(c.getName());
			}
			System.out.println("类的父类：");
			System.out.println(ImpInterface.class.getSuperclass());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

interface i1 {

}

interface i2 {

}

interface i3 {

}

class SImpInterface {

}

class ImpInterface extends SImpInterface implements i1, i2, i3 {

}