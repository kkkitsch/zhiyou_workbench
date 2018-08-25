package com.kkk.reflect;

/**
 * 获取Class类对象的三种方式
 * 
 * @author 刘利合
 *
 */
public class GetClassDemo {
	public static void main(String[] args) {
		/*
		 * 第一种方式 使用Object类中的getClass()方法获得
		 */
		SuperClass sup = new SuperClass();
		SubClass sub = new SubClass();
		Class<?> c1 = sup.getClass();
		Class<?> c2 = sub.getClass();
		System.out.println("类名：" + c1.getName());
		System.out.println("类名：" + c2.getName());

		/*
		 * 第二种方式 使用forName()加载对象
		 * 
		 */
		Class<?> c3 = null;
		try {
			c3 = Class.forName("com.example.reflect.GetClassDemo01");

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("类名：" + c3.getName());

		/*
		 * 第三种方式 类标记 使用 类名.class的形式生成Class对象
		 */
		Class<?> c4 = SuperClass.class;
		System.out.println("类名：" + c4.getName());

	}
}

class SuperClass // 定义一个父类
{
	public static void superMethod() {
		System.out.println("superClass中的方法");
	}
}

class SubClass extends SuperClass // 定义一个子类
{
	public static void SubClassMethod() {
		System.out.println("SubClassMethod中的方法");
	}
}