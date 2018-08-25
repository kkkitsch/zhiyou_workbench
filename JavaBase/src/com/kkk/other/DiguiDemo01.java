package com.kkk.other;

//递归阶乘
public class DiguiDemo01 {
	static int sum = 1;
	static int a = 1;

	public static void sum() {
		sum = sum * a;
		a++;
		if (a <= 10) {
			sum();// 调用自身实现递归
		}
	}

	public static void main(String[] args) {
		DiguiDemo01.sum();
		System.out.println("计算结果：" + DiguiDemo01.sum);
	}
}
