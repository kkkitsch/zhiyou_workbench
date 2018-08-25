package com.kkk.other;

import java.text.DecimalFormat;


public class DecimalDemo03 {
	public static void main(String[] args) {
		DecimalFormat d1=new DecimalFormat("000,000.000");
		System.out.println("000,000.000格式："+d1.format(123456.789D));
		DecimalFormat d2=new DecimalFormat("###,###,###");
		System.out.println("###,###,###格式："+d2.format(987654.321D));
		DecimalFormat d3=new DecimalFormat("$000,000,000");
		System.out.println("$000,000.000格式："+d3.format(123456.789));
		DecimalFormat d4=new DecimalFormat("###,###.##%");
		System.out.println("###,###.##%格式："+d4.format(0.123));
		DecimalFormat d5=new DecimalFormat("000.0000\u2030");
		System.out.println("000.0000\u2030格式："+d5.format(9.87654321D));
		DecimalFormat d6=new DecimalFormat("###.###");
		System.out.println("###.###格式："+d6.format(12345.6789));
	}
}
//DecimalFormat方法练习Q

