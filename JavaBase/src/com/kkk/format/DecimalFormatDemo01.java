package com.kkk.format;

import java.text.DecimalFormat;

/*
 * DecimalFormat类是NumberFormat类的子类 ，在格式十进制数字时，使用此类
 * 会更加方便，此类对应了一些模板化标记下面是具体的例子
 */
public class DecimalFormatDemo01 {
	public static void main(String[] args) {
		DecimalFormat d1 = new DecimalFormat("000,000.000");
		System.out.println("000,000.000格式：" + d1.format(123456.789));
		DecimalFormat d2 = new DecimalFormat("###,000.000");
		System.out.println("000,000.000格式：" + d2.format(123456.789));
		DecimalFormat d3 = new DecimalFormat("000.000");
		System.out.println("000.000格式：" + d3.format(12345.6789));
		DecimalFormat d4 = new DecimalFormat("$000.000");
		System.out.println("货币格式：" + d4.format(12345.6789));
		DecimalFormat d5 = new DecimalFormat("￥000.000");
		System.out.println("货币格式：" + d5.format(12345.6789));
		DecimalFormat d6 = new DecimalFormat("000,000.000%");
		System.out.println("货币格式：" + d6.format(123456.789));
		DecimalFormat d7 = new DecimalFormat("000,000.000\u2030");
		System.out.println("货币格式：" + d7.format(1234.56789));
	}
}
