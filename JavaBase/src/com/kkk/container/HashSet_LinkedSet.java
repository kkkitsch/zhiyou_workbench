package com.kkk.container;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/*
关于ArrayList，LinkedList，Vector的区别
ArrayList中允许有相同的元素，由于底层实现是数组，所以查询快，修改、删除慢，
LinkedList中允许有相同的元素，由于低层实现是链表，所以查询慢，修改、删除快，
ArrayList线程不安全，在程序设计中，如果只有一个线程访问集合，那么不用考虑线程安全，用ArrayList即可， 因为效率高
Vector线程安全，在程序设计中，如果只有多个线程访问集合，就得考虑线程安全，用Vector，效率不高

Set集合
Set集合中不能包含重复的元素，允许有一个null元素
HashSet中要重写equals()方法和HashCode()方法才能保证集合中的每个元素都不相同，此集合中输出的顺序和添加的顺序是无关的
TreeSet集合中的元素在默认情况下是升序的，TreeSet集合只能对实现了Comparable接口的类的对象进行排序，若想自定义的类创建
多个对象添加到此集合中实现排序，需让自定义的类实现Comparable接口，若没有实现此接口，自定义 的类只能向此集合中添加一个元素，
添加更多的话会有异常
 */

public class HashSet_LinkedSet {
	@Test
	public void testSet() {
		Set<Person01> set = new HashSet<Person01>();
		set.add(new Person01("llh", 18));
		set.add(new Person01("zxg", 18));
		set.add(new Person01("gh", 18));
		set.add(new Person01("sdy", 18));
		set.add(new Person01("yhy", 18));
		//输出
		for (Person01 person01 : set) {
			System.out.println(person01);
		}
	}
}

class Person01 {

	private String name;
	private int age;

	public Person01() {
		super();
	}

	public Person01(String name, int age) {
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
		return "Person01 [name=" + name + ", age=" + age + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person01 other = (Person01) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}