package com.kkk.other;
/*
 * 构造块   静态代码块  主方法的执行顺序
 * 静态代码块>主方法>构造块>构造方法
 * 无论是普通代码块  构造块  静态代码块 都可以定义变量  调用其他方法 
 * 使用各种控制语句  循环语句等
 * 普通代码块：在方法中出现的代码块   先出现的先执行
 * 
 * 构造块：直接在类中定义的，没有static修饰的，
 * 
 * 静态代码块：直接在类中定义的，有static修饰的，
 */
public class DaimakuaiDemo {
	{
		System.out.println("DaimakuaiDemo的构造块");
	}
	static
	{
		System.out.println("DaimakuaiDemo的静态代码块");
	}
	public DaimakuaiDemo()
	{
		System.out.println("DaimakuaiDemo的构造方法");
	}
	public static void main(String[] args) {
		System.out.println("DaimakuaiDemo的主方法");
		new D();
		new D();
		new DaimakuaiDemo();
		new DaimakuaiDemo();
	}
}
class D
{
	{
		System.out.println("D的构造块");
	}
	static
	{
		System.out.println("D的静态代码块");
	}
	public D()
	{
		System.out.println("D的构造方法");
	}
}