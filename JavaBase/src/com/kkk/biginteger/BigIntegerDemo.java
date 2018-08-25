package com.kkk.biginteger;

import java.math.BigInteger;

public class BigIntegerDemo {
	/*
	 * 当一个整数非常大，超过了long类型的取值范围时，就很难对其进行精确的运算了，
	 * 为此，java提供了BigInteger类型，此类型可以接收很大的整数，只要计算机的内 存足够大
	 */
	public static void main(String[] args) {
		String str1 = "1273927839274391";
		String str2 = "79274932879274927424294829";
		BigInteger b1 = new BigInteger(str1);
		BigInteger b2 = new BigInteger(str2);
		System.out.println("加法运算：" + b1.add(b2));
		System.out.println("减法运算：" + b2.subtract(b1));
		System.out.println("乘法运算：" + b1.multiply(b2));
		System.out.println("除法运算：" + b2.divide(b1));
		System.out.println("最大公约数：" + b1.gcd(b2));
		byte by[] = b1.toByteArray();
		System.out.println("二进制补码字节数组：");
		for (int i = 0; i < by.length; i++) {
			System.out.println(by[i]);
		}
	}
}
