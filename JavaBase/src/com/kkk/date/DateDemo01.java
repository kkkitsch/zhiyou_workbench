package com.kkk.date;

import java.util.Date;

/*
 * Date类识别精度为秒，已经不能满足需要
 * 为此，java提供了Calendar类
 */
public class DateDemo01 {
	public static void main(String[] args) {
		Date d1 = new Date();
		Date d2 = new Date(); // d1和d2几乎同时被实例化，也就是在同一秒被实例化，而Date类识别精度为秒，故认为d1和d2相同
		System.out.println("di和d2的先后顺序：" + d1.compareTo(d2));
		System.out.println("di和d2的先后顺序：" + d1.before(d2));
		System.out.println("di和d2的先后顺序：" + d1.after(d2));
		System.out.println("di和d2的先后顺序：" + d1.equals(d2));
		Date d3 = new Date(7392749327492L);
		System.out.println("d3所代表的时间：" + d3.toString());
	}
}
