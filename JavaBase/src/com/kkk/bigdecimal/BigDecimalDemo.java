package com.kkk.bigdecimal;

import java.math.BigDecimal;

public class BigDecimalDemo {
	/*
	 * 浮点数据类型不适合精确的运算，存在误差 进行精确的运算，需要使用BigDecimal类型
	 */
	public static void main(String[] args) {
		System.out.println("加法操作：" + add(323239.323, 7793792.3232));
		System.out.println("除法操作：" + devide(7749274.27392, 37294329.3242, 5));
	}

	public static double add(double d1, double d2) {
		BigDecimal b1 = new BigDecimal(d1);
		BigDecimal b2 = new BigDecimal(d2);
		return b1.add(b2).doubleValue();
	}

	public static BigDecimal devide(double d1, double d2, int i) {
		BigDecimal b1 = new BigDecimal(d1);
		BigDecimal b2 = new BigDecimal(d2);
		// i 表示小数点后有几位 ，ROUND.HALF_UP表示四舍五入
		return b1.divide(b2, i, BigDecimal.ROUND_HALF_UP);
	}
}
