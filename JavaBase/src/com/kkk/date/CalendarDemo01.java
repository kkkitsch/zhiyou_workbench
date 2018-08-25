package com.kkk.date;

import java.util.Calendar;

/*
 * Calendar类的时间精度为ms，且此类为抽象类，不能使用new为其实例化
 */
public class CalendarDemo01 {
public static void main(String[] args) {
	Calendar c1=Calendar.getInstance();
	System.out.println("year:"+c1.get(Calendar.YEAR));
	System.out.println("month:"+c1.get(Calendar.MONTH)+1);//获得月份时要加上1！！！
	System.out.println("day:"+c1.get(Calendar.DATE));
	System.out.println("今年的第"+c1.get(Calendar.DAY_OF_YEAR)+"天");
	System.out.println("本月的第"+c1.get(Calendar.DAY_OF_MONTH)+"天");
	System.out.println("星期："+(c1.get(Calendar.DAY_OF_WEEK)-1));//获取星期要减去1！！！
}
}
