package com.kkk.reflect;

import java.lang.reflect.Method;

import org.junit.Test;

public class GetMethod {

	// 通过反射操作方法
	@Test
	public void testMethod() throws Exception {
		Class<?> c = null;
		MethodDemo method = null;
		try {
			c = MethodDemo.class;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			method = (MethodDemo) c.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 获取所有方法
		Method[] methods = c.getDeclaredMethods();
		for (int i = 0; i < methods.length; i++) {
			// 设置可以访问
			methods[i].setAccessible(true);
			String methodName = methods[i].getName();
			System.out.println("方法名称：" + methodName);
			// 由于返回的方法不是按照顺序返回，所以先判断方法的名称，再调用具体的方法
			if (methodName.equals("privateMethod")) {
				// 通过反射机制执行参数可变的方法时，要将传入的参数设置成二维数组的形式
				Object[] obj = new Object[] { new String[] { "1", "2", "3" } };
				System.out.println(methods[i].invoke(method, obj));
			}
			if (methodName.equals("publicMethod")) {
				System.out.println(methods[i].invoke(method, 2));
			}
			if (methodName.equals("staticMethod")) {
				System.out.println(methods[i].invoke(method));
			}
			if (methodName.equals("protectedMethod")) {
				System.out.println(methods[i].invoke(method, 3.14F, 6));
			}
		}
	}
}

class MethodDemo {

	public static void staticMethod() {
		System.out.println("this is static method");
	}

	public int publicMethod(int i) throws Exception {
		return i * 2;
	}

	protected float protectedMethod(float f, int i) {
		return f + i;
	}

	private String privateMethod(String... str) {
		return str[0];
	}
}