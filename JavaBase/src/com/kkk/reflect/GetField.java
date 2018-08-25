package com.kkk.reflect;

import java.lang.reflect.Field;

import org.junit.Test;

// 获取类中的属性 并对属性修改 进行输出
public class GetField {
	@Test
	public void getField() {
		Class<?> c1 = null;
		FieldDemo field = new FieldDemo();
		System.out.println("类原本的信息：");
		System.out.println(field.toString());
		System.out.println("---------------------------------");
		try {
			c1 = FieldDemo.class;
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 获取类中的所有属性
		Field[] fields = c1.getDeclaredFields();
		// 遍历输出所有属性
		for (int i = 0; i < fields.length; i++) {
			fields[i].setAccessible(true);
			Class<?> fieldType = fields[i].getType();
			System.out.println("成员属性名称：" + fields[i].getName());
			System.out.println("成员属性类型：" + fieldType);
			try {
				// 修改返回值类型为int的数据
				if (fieldType.equals(int.class)) {
					System.out.println("修改前成员属性内容：" + fields[i].get(field));
					fields[i].set(field, 10000);
					System.out.println("修改后成员属性内容：" + fields[i].get(field));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("---------------------------------");
		}
		System.out.println("修改后的field对象信息：" + field);
	}
}

class FieldDemo {
	public int num = 100;
	private long id = 123425536463L;
	boolean flag = false;
	protected String str = "kkkitsch";

	public FieldDemo() {
	}

	public FieldDemo(int num, long id, boolean flag, String str) {
		super();
		this.num = num;
		this.id = id;
		this.flag = flag;
		this.str = str;
	}

	public long getId() {
		return id;
	}

	public int getNum() {
		return num;
	}

	public String getStr() {
		return str;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public void setStr(String str) {
		this.str = str;
	}

	@Override
	public String toString() {
		return "AField [num=" + num + ", id=" + id + ", flag=" + flag + ", str=" + str + "]";
	}

}