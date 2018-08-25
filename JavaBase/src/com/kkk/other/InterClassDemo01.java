package com.kkk.other;

//匿名内部类实现接口
public class InterClassDemo01 {
	public static void main(String [] args)
	{
		new InterClass().print();   //创建实例并且调用print方法  
	}
}
interface Inter    //定义接口   抽象方法
{
	public abstract void getInfo();
}
class InterClass
{
	public void print()
	{
		show(new Inter()   //匿名内部类   不能显式的实现接口
		{
			public void getInfo()
			{
				System.out.println("java学习手记");
			}
		});
	}
	public void show(Inter i)
	{
		i.getInfo();
	}

	
}