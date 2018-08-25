package com.kkk.container;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class Zhuyi03 {
	@Test
	public void test() {
		List<String> list = new ArrayList<String>();
		String s1 = new String("aaa");
		String s2 = new String("aaa");
		list.add(s1);
		list.add(s2);
		System.out.println(list.size());
		Map<String, String> map = new HashMap<String, String>();
		map.put(s1, "AAAAA");// 被s2覆盖 详见java视频108
		map.put(s2, "BBBBB");
		System.out.println(map.get("aaa"));
	}
}
