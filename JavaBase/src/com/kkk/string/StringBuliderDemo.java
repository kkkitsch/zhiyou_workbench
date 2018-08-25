package com.kkk.string;

public class StringBuliderDemo {
	/*
	 * StringBuilder和StringBuffer二者的区别主要是在运行速度和线程安全这两方面。
	 * 
	 * 1、StringBuffer 与 StringBuilder 中的方法和功能完全是等价的
	 * 
	 * 2、只是StringBuffer 中的方法大都采用了 synchronized 关键字进行修饰，因此是线程安全的，而 StringBuilder
	 * 没有这个修饰，可以被认为是线程不安全的。
	 * 
	 * 3、在单线程程序下，StringBuilder效率更快，因为它不需要加锁，不具备多线程安全而StringBuffer则每次都需要判断锁，
	 * 效率相对更低。
	 */
	public static void main(String[] args) {
		// 创建StringBuilder对象
		StringBuilder sb = new StringBuilder("this is a StringBulider Demo");
		System.out.println("StringBuilder:" + sb);

		// StringBuilder对象转为String对象
		String str = sb.toString().concat(" this is a concat!!!");
		System.out.println("String:" + str);
	}
}
