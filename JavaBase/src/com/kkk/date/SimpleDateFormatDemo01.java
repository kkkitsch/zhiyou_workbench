package com.kkk.date;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * 转换日期格式类
 */
public class SimpleDateFormatDemo01 {
	public static void main(String[] args) {
		String s1 = "yyyy 年   MM 月  dd  日   HH 时  mm 分    ss  秒    E";
		String s2 = " E  yyyy 年   MM 月  dd  日   HH 时  mm 分    ss  秒    ";
		SimpleDateFormat sim1 = new SimpleDateFormat(s1);
		SimpleDateFormat sim2 = new SimpleDateFormat(s2);
		String str1 = sim1.format(new Date());
		String str2 = sim2.format(new Date());
		System.out.println(str1);
		System.out.println(str2);

		System.out.println("----------------------");

		String str3 = "2017-03-23 21:03:00.000"; // str3的时间必须和str4的模板类型一致！！！
		String str4 = "yyyy-MM-dd HH:mm:ss.SSS";
		SimpleDateFormat s3 = new SimpleDateFormat(str4);
		Date d1 = null;
		try {
			d1 = s3.parse(str3);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(d1);
	}
}
