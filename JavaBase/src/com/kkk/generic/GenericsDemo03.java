package com.kkk.generic;

/*
 * 关于泛型方法的练习
 * 使用泛型方法时 泛型类型标识符应在修饰符的后面 返回值类型的前面 泛型方法可以写在泛型类中 也可以在泛型接中 还可以在普通类或普通接口中
 * 在泛型类或泛型接口中的方法本质上都是泛型方法 但是实际中很少在泛型类或泛型接口中显式地定义泛型方法 泛型方法可以被定义成实例方法 也可以被定义成静态方法
 * 这是与泛型类 泛型接口中的泛型方法的主要区别 本程序即是例子
 */
public class GenericsDemo03 {
	public static void main(String[] args) {
		Generics03 g3 = new Generics03(); // 创建实例
		System.out.println("姓名：" + g3.show("小明"));
		System.out.println("年龄：" + Generics03.staticShow("小明", 21));
		System.out.println("姓名：" + g3.<String>show("小明")); // String指定t的类型
															// 即：String==T
		System.out.println("年龄：" + Generics03.<Integer>staticShow("小明", 21)); // Integer指定的是t代表的类型
																				// 而不是s代表的类型
																				// s已经指定了类型"String"
		// 若指定的类型与实际不符 则会报错 例如 将21改为"21" 就会报错
	}
}

class Generics03 {
	public <T> T show(T t) // 使用泛型方法 泛型方法可以用在非泛型类中
	{
		return t;
	}

	public static <T> T staticShow(String s, T t) // 使用泛型方法
	{
		return t;
	}
}
