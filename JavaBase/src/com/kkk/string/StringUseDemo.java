package com.kkk.string;

public class StringUseDemo {
	public static void main(String[] args) {
		//从指定位置提取字符
		String s1="youareashit";
		char c1=s1.charAt(2);
		System.out.println(c1);
		
		//把数值转化为字符串
		int i1=123;
		String s2=String.valueOf(i1);
		System.out.println("123".equals(s2));
		
		//字符串转化为字符数组
		String s3="thisisastring";
		char c2[]=s3.toCharArray();
		for (int i = 0; i < c2.length; i++) {
			System.out.print(c2[i]+" ");
		}
		
		//把一个字符串中的某段字符串全部替换为指定字符串
		String s4="mynameisliulihehahahahahaha";
		String s5=s4.replaceAll("h", "l");
		System.out.println("\n"+s5);
		
		//判断字符串中是否有某个字符  存在返回零 否则返回1
		String s6="abcdefg";
		System.out.println(s6.indexOf("abc"));
		
		//连接两个字符串
		String s7="ll";
		String s8="h";
		System.out.println(s7.concat(s8)); 
		
		//截取字符串
		String s9="ihaveaapple";
		System.out.println(s9.substring(0, 2));
		//截取的并不包括2的索引
		
		//转换大小写
		String s10="llh";
		System.out.println(s10.toUpperCase());
		System.out.println(s10.toUpperCase().toLowerCase());
		
	}
}
