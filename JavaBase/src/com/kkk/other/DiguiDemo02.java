package com.kkk.other;

//数列：1，1，2，3，5，8，13……
//要求：输入7  输出13
import java.util.Scanner;

public class DiguiDemo02 {
	public static void main(String[] args) {
		System.out.println("请输入一个整数：");
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		int sum = suanfa(i);
		System.out.println(sum);
	}

	public static int suanfa(int a) {
		if (a == 1 || a == 2) {
			return 1;
		} else {
			return suanfa(a - 1) + suanfa(a - 2);
		}
	}
}

// 修改 输入5 输出1，1，2，3，5
//
// public class D {
// public static void main(String[] args) {
// System.out.println("请输入你要查询的位数：");
// Scanner sc=new Scanner(System.in);
// int n=sc.nextInt();
// for (int i =1; i <=n; i++) {
// int s=suanfa(i);
// System.out.println(s+" ");
// }
//
// }
// public static int suanfa(int n)
// {
// if (n==1||n==2)
// {
// return 1;
// }
// if (n>2)
// {
// return suanfa(n-1)+suanfa(n-2);
//
// }
// return 0;
// }
// }
