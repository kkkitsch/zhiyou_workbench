package com.kkk.enum_;

import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
 * Enum类是抽象类，每一个枚举成员都可以看成是一个实例，这些实例的默认属性为：public static final
 * 可以直接通过枚举类名.实例名来进行调用
 * 使用枚举类型的好处： 1、类型安全 2、运行效率高 3、可以和程序的其他部分交互
 */
public class EnumDemo01 {
	public static void main(String[] args) {
		Directions d1 = Directions.EAST; // 枚举成员的获得
		System.out.println("获得的枚举成员：" + d1);
		EnumDemo01.useSwitch(Directions.NORTH);
		EnumDemo01.print();
		EnumDemo01.enumMapDemo();

	}

	// 在switch中使用枚举
	public static void useSwitch(Directions d1) {
		switch (d1) {
		case EAST: {
			System.out.println("枚举成员为：EAST");
			break;
		}
		case WEST: {
			System.out.println("枚举成员为：WEST");
			break;
		}
		case SOUTH: {
			System.out.println("枚举成员为：SOUTH");
			break;
		}
		case NORTH: {
			System.out.println("枚举成员为：NORTH");
			break;
		}
		}
	}

	public static void print() { // 枚举类中的方法 ：values()可以将枚举成员以数组的形式返回
									// 同样的，valueOf()可以将字符串转变为枚举类型

		// for循环输出
		System.out.println("-----------------------------------");
		for (int i = 0; i < Directions.values().length; i++) {
			System.out.println(i + ":" + Directions.values()[i]);
			System.out.println("索引位置：" + Directions.values()[i].ordinal()); // 索引从0开始
			System.out.println("枚举成员名：" + Directions.values()[i].name());
			System.out.println("枚举成员名的属性：" + Directions.values()[i].getName());
		}
		System.out.println("---------------------------------");

		// foreach输出格式： for(数据类型 变量名: 数组名){}
		for (Directions dir : Directions.values()) {
			System.out.println(dir);
		}
	}

	// EnumMap类的使用
	public static void enumMapDemo() {
		System.out.println("---------------------------------");
		// EnuMap类的构造方法为：public EnumMap(Class<K> keytype) 所以创建EnumMap类必须指定一个枚举类
		EnumMap<Directions, String> e1 = new EnumMap<Directions, String>(Directions.class);
		e1.put(Directions.EAST, "东");
		e1.put(Directions.WEST, "西");
		e1.put(Directions.SOUTH, "南");
		e1.put(Directions.NORTH, "北");
		Set<Map.Entry<Directions, String>> set = e1.entrySet();
		Iterator<Map.Entry<Directions, String>> it = set.iterator();
		while (it.hasNext()) {
			Map.Entry<Directions, String> map = it.next();
			System.out.println("key:" + map.getKey());
			System.out.println("values:" + map.getValue());
		}

	}
}

enum Directions {
	EAST("东"), WEST("西"), SOUTH("南"), NORTH("北");// 为枚举成员定义属性
	private String name;

	private Directions(String name) // 枚举类可以有构造方法
	{
		this.name = name;
	}

	public String getName() {
		return name;
	}
}