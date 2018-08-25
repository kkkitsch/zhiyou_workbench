package com.kkk.other;

/*关于子类重写父类的方法中的一些绑定问题
 * 子类重写父类的静态方法和子类重写父类的实例方法，这两者的区别在于，
 * java虚拟机把静态方法和所属的类绑定，而把实例方法和所属的实例绑定，
 * 成员变量（静态变量和实例变量）和所属的类绑定
 * 
 * Person01  p1  =  new Student01();
 * p1所属的类                             p1所属的实例
 */
public class FatherAndSonBangdingDemo {
	public static void main(String[] args) {
		Person01 p1=new Student01();//向上转型
		System.out.println("p1.i1="+p1.i1+",\tp1.i2="+p1.i2);
		p1.tell();
		p1.staticTell();
		Student01 s1=(Student01)p1;
		System.out.println("s1.i1="+s1.i1+",\ts1.i2="+s1.i2);
		s1.tell();
		s1.staticTell();
	}
}
class Person01
{
	int i1=1;
	static int i2=100;
	public void tell()
	{
		System.out.println("父类实例tell方法");
	}
	public static void staticTell()
	{
		System.out.println("父类静态 tell方法");
	}
}
class Student01 extends Person01
{
	int i1=2;
	static int i2=200;
	public void tell()
	{
		System.out.println("子类实例tell方法");
	}
	public static void staticTell()
	{
		System.out.println("子类静态tell方法");
	}
}