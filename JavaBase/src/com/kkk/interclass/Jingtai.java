package com.kkk.interclass;

import org.junit.Test;

/**
 * @description 测试静态内部类
 * @author Administrator
 */
public class Jingtai {

	@Test
	public void test() {
		/*
		 * 静态内部类也是定义在另一个类里面的类，只不过在类的前面多了一个关键字static。静态内部类是不需要依赖于外部类的，
		 * 这点和类的静态成员属性有点类似，并且它不能使用外部类的非static成员变量或者方法，这点很好理解，因为在没有外部类的对象的情况下，
		 * 可以创建静态内部类的对象，如果允许访问外部类的非static成员就会产生矛盾，因为外部类的非static成员必须依附于具体的对象。
		 * 
		 * 创建静态内部类的方式：外部类.内部类 内部类对象=new 外部类.静态内部类();
		 */
		Outter01.Inner01 inner = new Outter01.Inner01();
		inner.test();
	}
}

class Outter01 {

	static int i1 = 1;
	int i2 = 2;

	public Outter01() {

	}

	// 外部类实例方法
	public void outterMethod() {
		System.out.println("outterMethod......");
	}

	// 外部类静态方法
	public static void staticOutterMethod() {
		System.out.println("staticOutterMethod......");
	}

	// 静态内部类
	static class Inner01 {
		public Inner01() {
			// 访问外部类中的静态变量
			System.out.println(i1);

			// 静态内部类中不能访问非静态成员，如下：
			// System.out.println(i2);
		}

		// 静态内部类中可以定义非静态方法
		public void test() {
			// 静态内部类中不能访问外部类中的非静态方法，如下：
			// outterMethod();

			// 静态内部类访问外部类中的静态方法，如下：
			staticOutterMethod();
		}
	}
}