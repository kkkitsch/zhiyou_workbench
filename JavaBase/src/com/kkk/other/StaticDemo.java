package com.kkk.other;

/**
 * @author 刘利合
 *  static关键词的练习
 *
 *  成员变量 方法加上static后直接通过类名调用 
 *  成员变量加上static后 成为广义上的全局变量 
 *  静态方法不能直接访问非静态成员和方法    必须通过类的实例
 */
public class StaticDemo {
	int i1 = 1;
	String str11 = "str";
	static String str2 = "staticstr";

	public static void main(String[] args) {
		System.out.println("---------------------------");
		System.out.println(StaticDemo.str2);
		StaticDemo.print();
	}

	public static void print() {
		StaticDemo s = new StaticDemo();
		System.out.println(s.i1);
	}
}
