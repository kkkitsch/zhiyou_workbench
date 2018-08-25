package com.kkk.date;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/*
 * 日期格式转换类  此类同Calendar一样  同为抽象类
 */
public class DateFormatDemo01 {
public static void main(String[] args) {
	DateFormat d1=DateFormat.getInstance();
	DateFormat d2=DateFormat.getDateInstance();
	DateFormat d3=DateFormat.getTimeInstance();
	DateFormat d4=DateFormat.getDateTimeInstance();
	System.out.println(d1.format(new Date()));
	System.out.println(d2.format(new Date()));
	System.out.println(d3.format(new Date()));
	System.out.println(d4.format(new Date()));
	System.out.println("------------------------------");
	DateFormat d5=DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT, Locale.CHINA);
	DateFormat d6=DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM, Locale.CHINA);
	DateFormat d7=DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, Locale.CHINA);
	DateFormat d8=DateFormat.getDateTimeInstance(DateFormat.DEFAULT, DateFormat.DEFAULT, Locale.CHINA);
	System.out.println(d5.format(new Date()));
	System.out.println(d6.format(new Date()));
	System.out.println(d7.format(new Date()));
	System.out.println(d8.format(new Date()));
	
}
}
