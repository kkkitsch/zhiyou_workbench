package com.kkk.object;

public class ObjectDemo03 {
	public static void main(String[] args) throws CloneNotSupportedException {
		Person03 p1 = new Person03("llh", 18);
		Person03 p2 = (Person03) p1.clone();
		System.out.println("p1和p2是否相等：" + p1.equals(p2));
		System.out.println("p1和p2的hashcode值是否相等：" + (p1.hashCode() == p2.hashCode()));
	}
}

class Person03 implements Cloneable {
	private String name;
	private int age;

	public Person03() {
	}

	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
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
		Person03 other = (Person03) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public Person03(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
