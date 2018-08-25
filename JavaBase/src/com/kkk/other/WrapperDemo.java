package com.kkk.other;

//装箱和拆箱
/*
 * 所有包装类都提供了toString()方法
 */
public class WrapperDemo {
	public static void main(String[] args) {
		//手动装箱
		int i1=100;
		Integer i2=new Integer(i1);
		System.out.println("包装器 Integer类型i2="+i2);
		//手动拆箱
		Float f1=new Float(3.14F);
		float f2=f1.floatValue();
		System.out.println("基本数据类型float f2="+f2);
		//自动装箱
		int i3=1000;
		Integer i4=i3;
		System.out.println("包装器 Integer类型i4="+i4);
		//自动拆箱
		Float f3=new Float(3.14F);
		float f4=f3;
		System.out.println("基本数据类型float f4="+f4);
		
		//toString()方法
		String s1=i2.toString();
		String s2=f1.toString();
		String s3=i4.toString();
		String s4=f3.toString();
		System.out.println("\n用字符串表示：s1="+s1+"  s2="+s2+"  s3="+s3+"  s4="+s4);
		
		//将字符串类型的数字转化为 数值
		String s5="12345";
		String s6="3.1415926";  //字符串必须全部为数字
		int i5=Integer.parseInt(s5);
		double d1=Double.parseDouble(s6);
		System.out.println("\n字符串的数值表示形式：i5="+i5+",d1="+d1);
		
		//Boolean包装器类
		if (Boolean.parseBoolean("TRUE"))
		{
			System.out.println("\ntrue");
		}
		else
		{
			System.out.println("\nfalse");
		}
		
	}
}
