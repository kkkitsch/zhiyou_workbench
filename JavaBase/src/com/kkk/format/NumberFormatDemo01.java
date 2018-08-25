package com.kkk.format;

import java.text.NumberFormat;
import java.util.Locale;

/*
 * NumberFormat类是抽象类，不能通过new为其实例化，可以通过此类的静态方法获得此类的实例
 */
public class NumberFormatDemo01 {
	public static void main(String[] args) {
		System.out.println("默认格式：");
		NumberFormat n1 = NumberFormat.getInstance();
		System.out.println(n1.format(62632863.323234));
		System.out.println(n1.format(797968688635453L));
		System.out.println("指定格式(德国)：");
		NumberFormat n2 = NumberFormat.getIntegerInstance(Locale.GERMAN);
		System.out.println(n2.format(68832973.2324));
		System.out.println(n2.format(638263263279272L));
		System.out.println("指定格式(美国)：");
		NumberFormat n3 = NumberFormat.getCurrencyInstance(Locale.US);
		System.out.println(n3.format(68832973.2324));
		System.out.println(n3.format(638263263279272L));
		System.out.println("默认格式：");
		NumberFormat n4 = NumberFormat.getPercentInstance();
		System.out.println(n4.format(0.123));
	}
}
