package com.kkk.other;


//输入一个字符串   判断是否是回文数

import java.util.Scanner;
public class huiwenshu
{
	public static void main(String[] args) 
	{
		String first;
		System.out.println("请输入一个字符串：");
		Scanner in =new Scanner(System.in);
		first=in.next();
		StringBuffer second=new StringBuffer(first);
		if (first.equals(second.reverse().toString()))
		{
			System.out.println("这是回文数");
		}
		else
		{
			System.out.println("这不是回文数");
		}
	}
}
