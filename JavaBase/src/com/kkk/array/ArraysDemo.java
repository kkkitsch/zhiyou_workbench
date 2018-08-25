package com.kkk.array;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ArraysDemo {

	@Test
	public void asList() {

		/*
		 * asList(T... a) 返回一个受指定数组支持的固定大小的列表。
		 */
		List<String> strArray = Arrays.asList("kitsch", "tony", "steven", "alice");
		for (String string : strArray) {
			System.out.print(string + " ");
		}
		System.out.println();

		List<Integer> intList = Arrays.asList(1, 2, 3, 4);
		for (Integer integer : intList) {
			System.out.print(integer + " ");
		}
	}

	@Test
	public void binarySearch() {
		// binarySearch方法支持在整个数组中查找，如：
		int index = Arrays.binarySearch(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 6);
		System.out.println("下标地址： " + index);
		// 以及在某个区间范围内查找， 如下：表示索引 从1~6开始查找
		int index1 = Arrays.binarySearch(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 4, 6, 5);
		System.out.println("下标地址： " + index1);
	}

	@Test
	public void copyOf() {
		String[] names = { "Eric", "John", "Alan", "Liz" };
		// 复制数组names的前三个
		String[] copy = Arrays.copyOf(names, 3);
		for (String string : copy) {
			System.out.print(string + " ");
		}
		System.out.println();

		// 复制names数组的索引从2~4，不包括4
		String[] rangeCopy = Arrays.copyOfRange(names, 2, names.length);
		for (String string : rangeCopy) {
			System.out.print(string + " ");
		}
	}

	@Test
	public void sort() {
		String[] names = { "Liz", "John", "Eric", "Alan" };

		// 排序0~2的names，不包括2
		Arrays.sort(names, 0, 2);
		for (String string : names) {
			System.out.print(string + " ");
		}
		System.out.println();

		// 返回值为void,排序所有
		Arrays.sort(names);
		for (String string : names) {
			System.out.print(string + " ");
		}
	}

	@Test
	public void toStringDemo() {
		// Arrays的toString方法可以方便我们打印出数组内容。
		String[] names = { "Liz", "John", "Eric", "Alan" };
		Arrays.sort(names);
		System.out.println(Arrays.toString(names));
	}

	@Test
	public void deepToString() {
		// 如果需要打印二维数组的内容：
		int[][] stuGrades = { { 80, 81, 82 }, { 84, 85, 86 }, { 87, 88, 89 } };
		// 直接打印二维数组的内容得到的结果：[[I@28c97a5, [I@6659c656, [I@6d5380c2]
		System.out.println(Arrays.toString(stuGrades));
		// 需要用到deepToString 方法才能得到正确的结果
		System.out.println(Arrays.deepToString(stuGrades));
	}

	@Test
	public void equals() {
		// 使用Arrays.equals来比较1维数组是否相等。
		String[] names1 = { "John", "Eric", "Alan", "Liz" };
		String[] names2 = { "John", "Eric", "Alan", "Liz" };
		// 使用方法进行比较，比较的是数据是否相等
		System.out.println(Arrays.equals(names1, names2));
		// 使用==，比较的是引用
		System.out.println(names1 == names2);
	}

	@Test
	public void deepEquals() {
		// Arrays.deepEquals能够去判断更加复杂的数组是否相等。
		int[][] stuGrades1 = { { 80, 81, 82 }, { 84, 85, 86 }, { 87, 88, 89 } };
		int[][] stuGrades2 = { { 80, 81, 82 }, { 84, 85, 86 }, { 87, 88, 89 } };
		System.out.println(Arrays.deepEquals(stuGrades1, stuGrades2));
	}

	@Test
	public void fill() {
		int[] array = new int[8];
		// 填充数组
		Arrays.fill(array, 1);
		System.out.println(Arrays.toString(array));
	}
}
