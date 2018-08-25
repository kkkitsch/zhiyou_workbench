package com.kkk.array;

import java.util.Arrays;

import org.junit.Test;

public class ArrayUseDemo {

	public ArrayUseDemo() {
	}

	/*
	 * 数组必知：
	 * 
	 * 1、数组是相同数据类型（数据类型可以是任意类型）的有序集合
	 * 
	 * 2、数组也是对象
	 * 
	 * 3、数组长度是确定的，不可变的
	 */
	@Test
	public void test1() {
		// 数组的规范使用---1
		int[] arr = null;
		arr = new int[2];
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();

		// 数组的规范使用---2
		int[] arr1 = new int[2];
		for (int i : arr1) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	/*
	 * 数组的初始化
	 */
	@Test
	public void test2() {

		// 静态初始化---1
		int[] arr1 = { 1, 2, 3 };
		for (int i : arr1) {
			System.out.print(i + " ");
		}
		System.out.println();

		// 静态初始化---2
		int[] arr2 = new int[] { 1, 2, 3 };
		for (int i : arr2) {
			System.out.print(i + " ");
		}
		System.out.println();

		// 数组的动态初始化
		int[] arr3 = new int[3];
		arr3[0] = 1;
		arr3[1] = 1;
		arr3[2] = 1;
		for (int i : arr3) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	/*
	 * 二维数组的使用
	 */
	@Test
	public void test3() {
		int[][] arr1 = new int[2][2];
		arr1 = new int[][] { { 1, 1 }, { 2, 2 }, { 3, 3 }, { 4, 5 } };
		System.out.println("arr1.length: " + arr1.length);
		System.out.println("arr1[2].length : " + arr1[2].length);
		System.out.println("arr1[3][1] : " + arr1[3][1]);

		// 直接使用foreach循环输出二位数组，输出的是地址
		for (int[] is : arr1) {
			System.out.println(is);
		}

		// 使用foreach循环输出二维数组
		for (int[] is : arr1) {
			for (int i : is) {
				System.out.print(i + " ");
			}
			System.out.println();
		}

		// 可以使用Arrays类来实现二维数组的输出
		System.out.println("使用Arrays类来实现二维数组的输出: " + Arrays.deepToString(arr1));
	}

	/*
	 * 数组的错误使用
	 */
	@Test
	public void test4() {

		// 错误使用---1，不可既定义数组范围，又定义数值
		// int[] arr1 = new int[2] { 1, 2 };

		// 错误使用---2，不可不使用下标
		// int[] arr2 = new int[2];
		// arr2={1,2};

		// 错误使用---3，超出数值范围
		// byte[] arr3 = new byte[] { 1, 2, 128 };

		// 数组的错误使用---4，数据类型不一样
		// byte[] arr4 = new int[] { 1, 2, 3 };
	}

}
