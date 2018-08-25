package com.kkk.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ObjectOutputStreamDemo {

	// 输出对象到文本文件
	@Test
	public void test() {
		// 定义Student实例,在多个数据对象的情况下，会使用集合来保存对象，然后再对集合中的对象进行序列化和反序列化操作
		Student stu1 = new Student("kkk", 21, "zygxy");
		Student stu2 = new Student("jack", 21, "lsz");
		Student stu3 = new Student("tom", 21, "fjsl");
		Student stu4 = new Student("steven", 21, "fsk");
		Student stu5 = new Student("alice", 21, "sss");
		// 从源码可知：ArrayList实现了java.io.Serializable序列化接口
		List<Student> list = new ArrayList<Student>();
		list.add(stu1);
		list.add(stu2);
		list.add(stu3);
		list.add(stu4);
		list.add(stu5);
		// 定义文件实例
		File file = new File("D:/zy/eclipse/IOWorkBench/ObjectOutputStream.txt");
		OutputStream output = null;
		ObjectOutputStream oos = null;
		try {
			// 实例化对象
			output = new FileOutputStream(file);
			oos = new ObjectOutputStream(output);
			// 将对象输出到文本文件
			oos.writeObject(list);
			System.out.println("保存对象成功");
		} catch (Exception e) {
			System.out.println("保存对象失败 ");
			e.printStackTrace();
		} finally {
			// 关闭流
			closeOutputConn(oos, output);
		}
	}

	// 从文本文件获取对象
	@Test
	public void testGetObject() {
		// 文件实例
		File file = new File("D:/zy/eclipse/IOWorkBench/ObjectOutputStream.txt");
		InputStream input = null;
		ObjectInputStream ois = null;
		try {
			// 实例化对象
			input = new FileInputStream(file);
			ois = new ObjectInputStream(input);
			// 从文本文件中获取对象
			ArrayList<Student> list = (ArrayList<Student>) ois.readObject();
			System.out.println("读取文件对象成功");
			// 输出集合内容
			for (Student student : list) {
				System.out.println(student);
			}
		} catch (Exception e) {
			System.out.println("读取文件对象失败");
			e.printStackTrace();
		} finally {
			ObjectOutputStreamDemo.closeInputConn(ois, input);
		}
	}

	// 关闭流
	public static void closeInputConn(Object... obj) {
		for (Object object : obj) {
			try {
				if (obj != null) {
					InputStream input = (InputStream) object;
					input.close();
				}
			} catch (Exception e) {
				System.out.println("关闭流失败！");
			}
		}
		System.out.println("关闭流成功！");
	}

	// 关闭流
	public static void closeOutputConn(Object... obj) {
		for (Object object : obj) {
			try {
				if (obj != null) {
					OutputStream output = (OutputStream) object;
					output.close();
				}
			} catch (Exception e) {
				System.out.println("关闭流失败！");
			}
		}
		System.out.println("关闭流成功！");
	}
}

/*
 * 实现序列化有 两种方法：1、实现Serializable，2、实现Externalizable，一般推荐第一种，因为方便
 * 实现Serializable接口，可以被序列化的内容： 1、属性：基本数据类型，数组，引用数据类型 ，2、类名
 * 实现Serializable接口，不能被序列化的内容： 1、类中的所有方法，2、static关键词和transient关键字修饰的属性
 * 实现Serializable接口，如果不需要对某个属性实现序列化，可以在定义 属性时加上：transient
 */
class Student implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private Integer age;
	private transient String school;

	public Student() {
	}

	public Student(String name, Integer age, String school) {
		super();
		this.name = name;
		this.age = age;
		this.school = school;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", school=" + school + "]";
	}

}