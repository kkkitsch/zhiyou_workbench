package com.kkk.reflect;

import java.lang.reflect.Constructor;

import org.junit.Test;

public class ConstructorDemo {
	// 通过有参构造方法实例化对象
	@Test
	public void testConstructor() {
		Class<?> c = null;
		Student[] stu = new Student[4];
		Constructor<?> con[] = null;
		try {
			c = Student.class;
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 获取所有构造方法
		con = c.getConstructors();
		for (Constructor<?> constructor : con) {
			System.out.println("构造方法：" + constructor);
		}
		try {
			// 向指定的构造方法传入参数，并实例化对象，值得注意的是，获取构造方法，是按照构造方法的倒序进行排列
			stu[0] = (Student) con[0].newInstance("kkk", 21);
			stu[1] = (Student) con[1].newInstance("alice");
			stu[2] = (Student) con[2].newInstance(22);
			stu[3] = (Student) con[3].newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 输出student信息
		for (Student student : stu) {
			System.out.println(student);
		}
	}
}

class Student {
	private String name;
	private int age;

	public Student() {
		super();
	}

	public Student(int age) {
		super();
		this.age = age;
	}

	public Student(String name) {
		super();
		this.name = name;
	}

	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}

}