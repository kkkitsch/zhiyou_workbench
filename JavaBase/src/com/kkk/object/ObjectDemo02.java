package com.kkk.object;

public class ObjectDemo02 {
	public static void main(String[] args) {
		Person02 p1 = new Person02("001", 11); // 创建类的实例
		Person02 p2 = new Person02("002", 22);
		Person02 p3 = new Person02("001", 11);
		System.out.println("p1的hashCode码值：" + p1.hashCode()); // p1输出哈希值
		System.out.println("p2的hashCode码值：" + p2.hashCode()); // p2输出哈希值

		System.out.println("p3的hashCode码值：" + p3.hashCode()); // p3输出哈希值

		if (p1.equals(p3)) // 比较p1 和 p3 equals方法的形参必须是Object类型
		{
			System.out.println("p1 and p3是相同的");
		} else {
			System.out.println("p1 and p3是不相同的");

		}
		if (p1.equals(p3 = p2)) // 比较p1 和 p2
		{
			System.out.println("p1 and p3是相同的");
		} else {
			System.out.println("p1 and p3是不相同的");

		}
	}
}

class Person02 {
	private String name; // 声明属性
	private int age;

	public Person02() // 无参构造方法
	{

	}

	public Person02(String name, int age) // 有参构造方法 为属性初始化
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

	public boolean equals(Object o) // 重写Object类中的equals()方法
	{
		if (this == o) // 判断当前对象和指定对象是否相等
		{
			return true;
		}
		if (o == null) // 判断指定对象是否为空
		{
			return false;
		}
		if (!(o instanceof Person)) // 判断指定对象是否为类的实例
		{
			return false;
		}
		Person per = (Person) o; // 将指定对象转为Person类的实例
		if (this.name.equals(per.name) && this.age == per.age) // 比较对象的属性是否相等
		{
			return true;
		} else {
			return false;
		}
	}

	public int hashCode() // hashCode方法
	{
		final int prime = 13;
		int result = 13;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + age;
		return result;
	}
}
