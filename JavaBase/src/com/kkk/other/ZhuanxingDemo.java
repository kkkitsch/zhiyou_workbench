package com.kkk.other;

//关于转型的练习 
public class ZhuanxingDemo {
	public static void main(String[] args) {
		Person p1=new Student();//向上转型
		p1.tell();//向上转型后调用子类tell方法
		//p1.print();不能调用子类新增的方法
		Student s1=(Student)p1;//向下转型的正确方法
		s1.tell();//调用子类tell方法
		s1.say();//调用父类say方法
		s1.print();//调用子类print()方法
	}
}
class Person
{
	Person(){}
	public void tell()
	{
		System.out.println("父类tell方法");
	}
	public void say()
	{
		System.out.println("父类say方法");
	}
}
class Student extends Person
{
	Student(){}
	public void tell()
	{
		System.out.println("子类tell方法");
	}
	public void print()
	{
		System.out.println("子类print方法");
	}
}