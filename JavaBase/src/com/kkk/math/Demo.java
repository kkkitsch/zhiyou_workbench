package com.kkk.math;

public class Demo {
	public static void main(String[] args) {
		// 得到绝对值
		System.out.println(Math.abs(21.21D));

		// 得到三角函数值 ，PI 比任何其他值都更接近 pi（即圆的周长与直径之比）的 double 值。
		System.out.println("90°正弦值：" + Math.sin(Math.PI / 2));
		System.out.println("60°余弦值：" + Math.cos(Math.PI / 3));
		System.out.println("45°正切值：" + Math.tan(Math.PI / 4));

		// 得到两个数中较大的一个
		System.out.println(Math.max(3.0D, 2.0D));

		// 得到两个数中较小的一个
		System.out.println(Math.min(3, 2));

		// 返回带正号的 double 值，该值大于等于 0.0 且小于 1.0。
		System.out.println(Math.random());

		// 返回第一个参数的第二个参数次幂的值
		System.out.println(Math.pow(2.0D, 3.0D));

		// 返回平方根
		System.out.println(Math.sqrt(4.00D));

	}
}
