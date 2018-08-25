package com.kkk.generic;

/*
 * 注意事项：
 * 
 * 理解：泛型类相当于是一个模板，提供了供多种类型使用的泛化型类，在实际操作中，如下例所示，可以看作是操作一个Integer类的对象，只不过表现形式不同而已
 * 
 * 1、泛型类继承Throwable及其子类都是不合法的 这样的程序编译无法通过
 * 
 * 2、java规定不能使用泛型类型的数组 所以： T t[] 这样的是错误的
 * 
 * 3、不能将类声明为： class Generics<? extends Number>{}
 * 因为通配符是用来声明一个泛型类的变量的，而不是用来创建一个泛型类的
 * 
 * 4、使用通配符设置对象时，不能通过setter方法设置被泛型指定的内容，例子如下： Generics <?,?> ge=new
 * Generics<Integer,String>(); ge.setObj1(122); //错误：不能设置被泛型指定内容！ 但是可以设置为null
 * ge.setObj1(null); //可以这样操作
 */
public class GenericsDemo01 {
	public static void main(String[] args) {
		Generics<Integer> g1 = new Generics<Integer>();// 创建Generics类的实例
		g1.setB(110); // 给g1实例设定数值 自动封装成Integer类型
		System.out.println("设置的值为：" + g1); // 输出数据
		info(g1);
	}

	public static void info(Generics<? super Integer> x) // 设置并接收泛型类型通配符的下限
															// 只能接收Integer，Number，和Object类型的
	{
		System.out.println("info():" + x);
	}

	public static void info01(Generics<? extends Number> x) // 设置并接收泛型类型通配符的上限
															// 只能接收Number类及其子类的对象
	{
		System.out.println("info():" + x);
	}
}

class Generics<T> // 泛型类型不能是基本数据类型
{
	private T b; // 私有化属性
	// T t=new T(); 不能直接使用参数类型来构造一个对象
	// private static T c; 泛型不能定义 静态属性

	public Generics() // 无参构造方法 泛型类的构造方法和一般类的构造方法并无不同
	{

	}

	public Generics(T b) // 有参构造方法
	{
		setB(b);
	}

	public T getB() {
		return b;
	}

	public void setB(T b) {
		this.b = b;
	}

	public String toString() {
		return getB().toString();
	}
}