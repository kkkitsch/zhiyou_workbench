package com.kkk.interclass;

import org.junit.Test;

/**
 * 
 * @description 测试成员内部类的使用方式
 * @author Administrator
 *
 */
public class ChengyuanInnerClass {

	/*
	 * 进行单元测试
	 */
	@Test
	public void test1() {

		// 创建成员内部类对象的方式---1：外部类.内部类 内部类对象 =new 外部类().new 内部类()
		Outter.Inner inner = new Outter().new Inner();
		inner.print();

		// 创建成员内部类对象的方式---2：外部类.内部类 内部类对象 =外部类对象.new 内部类()
		// Outter outter = new Outter();
		// Outter.Inner inner1 = outter.getInnerInstance();
		// inner1.print();
	}

}

class Outter {
	private Inner inner = null;
	private int i = 1;

	public Outter() {

	}

	public Inner getInnerInstance() {
		if (inner == null)
			inner = new Inner();
		return inner;
	}

	private void tell() {

		System.out.println("外部类中的tell()......");

		// 在外部类中访问内部类的say()方法，首先要定义一个内部类的对象，利用对象才能访问内部类中的方法，如下：
		Outter.Inner inner2 = new Outter().new Inner();
		inner2.say();

		// 不能直接在外部类中访问内部类的方法，如下：
		// speak();
	}

	class Inner {

		int i = 2;

		public Inner() {

		}

		public void print() {
			System.out.println("内部类的print()......");

			// 当外部类的对象名称和内部类的对象名称一致时，直接在内部类访问变量，访问的是内部类的变量，如下：
			System.out.println("内部类中的i:" + i);

			// 如果在内部类中想访问外部类的变量，如下：
			System.out.println("外部类中的i:" + Outter.this.i);

			// 访问的是内部类中的tell()方法
			tell();

			// 访问外部类中的tell()方法
			Outter.this.tell();
		}

		// 方法被private修饰，只能在内部类中访问
		private void tell() {
			System.out.println("内部类中的tell()......");
		}

		// 内部类中的speak()方法
		public void speak() {
			System.out.println("内部类中的speak()......");
		}

		// 内部类中的say()方法
		public void say() {
			System.out.println("内部类中的say()......");
		}
	}
}