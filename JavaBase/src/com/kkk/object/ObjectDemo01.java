package com.kkk.object;

public class ObjectDemo01 {
	public static void main(String[] args) {
		Person p = new Person("小明", 12); // 创建类的实例
		System.out.println(p);
		System.out.println(p.toString()); // p.toStirng()方法要放在输出里
	}
}

class Person {
	String name; // 声明属性
	int age;

	public Person() {
	} // 无参构造方法

	public Person(String name, int age) // 有参构造方法 为属性初始化
	{
		this.age = age;
		this.name = name;

	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public String toString() // 重写Object类中的toString()方法
	{
		return ("姓名：" + name + "，年龄：" + age);
	}
}