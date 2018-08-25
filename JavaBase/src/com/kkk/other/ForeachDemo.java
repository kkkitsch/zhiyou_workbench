package com.kkk.other;


public class ForeachDemo {
	public static void main(String[] args) {
		int arr[] = { 12, 34, 56 };
		for (int i : arr) // for(数据类型 变量 : 数组) 数组的数据类型和第一个数据类型必须保持一致
		{
			System.out.println(i);
		}
	}
}
