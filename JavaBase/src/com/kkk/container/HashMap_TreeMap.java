package com.kkk.container;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.junit.Test;

import java.util.Set;
import java.util.TreeMap;

/*
 *HashMap对于元素的删除和添加有着较高的效率，允许有null值和null键，但是必须保证是唯一的，
 *Map集合中的key和value是一一对应的，可以通过key获取相对应的value
 *TreeMap集合中的元素具有一定的顺序性，默认对key值升序排列，此集合对元素的添加、删除性能较低
 *HashMap输出的元素是无序的，TreeMap输出的元素是有序的
 *
 *Map集合转换成Collection集合时要保持泛型的一致，Map集合本省不能使用迭代器输出，若想使用
 *迭代器输出，首先Map集合实例通过entrySet()方法转换成为Set集合，再由Set集合实例化迭代器，
 *这时，迭代器可以输出Map.Entry对象，Map.Entry对象通过getKey()和getValue()方法分离Map集
 *合的key和value
 *
 *HashMap和HashTable的区别
 *HashTable是线程安全的，也就是说是同步的，性能相对较低，不允许存在null值和null键
 *HashMap是线程不安全的，不是同步的，性能相对较高，允许存在一个null值和null键
 */
//HashMap，TreeMap的练习
public class HashMap_TreeMap {
	@Test
	public void testMap() {
		// 定义一个HashMap存储数据
		Map<String, String> map = new HashMap<String, String>();
		// 存放数据
		map.put("jack", "jackname");
		map.put("july", "july");
		map.put("kitsch", "kitsch");
		map.put("mars", "mars");

		// 注意两者输出的区别
		System.out.println(map.get(1));
		System.out.println(map.get("mars"));
		System.out.println("HashMap的输出：");
		printMap(map);

		Map<String, String> tp = new TreeMap<String, String>();
		// 因为String类已经实现了Comparable接口，所以程序可以运行，若是自定义的类，则需要实
		// 现Comparable接口，否则将会出现类型转换异常
		tp.putAll(map);
		System.out.println("TreeMap的输出：");
		printMap(map);
	}

	public void printMap(Map<String, String> map) {
		Set<Map.Entry<String, String>> mapentry = map.entrySet();
		Iterator<Map.Entry<String, String>> it = mapentry.iterator();
		System.out.println("key----->values");
		while (it.hasNext()) {
			Map.Entry<String, String> me = it.next();
			System.out.println(me);
		}
	}
}
