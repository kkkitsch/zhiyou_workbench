package com.kkk.zzbds;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class Demo01 {
	@Test
	public void testEmail() {
		String regex = "\\d{11}";
		String str = "this is a number 12345678901";
		Pattern pat = Pattern.compile(regex);
		Matcher mat = pat.matcher(str);
		if (mat.find()) {
			System.out.println("匹配成功");
			System.out.println(mat.group());
		} else {
			System.out.println("匹配失败");
		}
	}
}
