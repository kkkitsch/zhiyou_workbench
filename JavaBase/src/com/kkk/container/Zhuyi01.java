package com.kkk.container;

import java.util.HashMap;
import java.util.Map;

/*
 * 因为自定义的类没有像String类那样有缓冲池机制，所以put()方法中 的new Test("zzti")与get()方法中的new
 * Test("zzti")不是同一个对 象，输出的是null，若想解决上述的问题，可以在自定义的类中重写equals()方法和hashCode()方法
 * 
 * HashCode值相同，并不代表这两个对象相等，hashCode方法的作用就是提高效率，放两个对象比较的时候，
 * 先比较hashCode值，如果相同，再进行equals方法的比较，如果不同，就不用比较了！
 */
public class Zhuyi01 {

	@org.junit.Test
	public void test() {
		Map<Test, String> map = new HashMap<Test, String>();
		map.put(new Test("zzti"), "中原工学院");
		System.out.println(map.get(new Test("zzti")));
	}
}

class Test {
	private String str;

	public Test() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Test(String str) {
		super();
		this.str = str;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	@Override
	public String toString() {
		return "Test [str=" + str + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((str == null) ? 0 : str.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Test other = (Test) obj;
		if (str == null) {
			if (other.str != null)
				return false;
		} else if (!str.equals(other.str))
			return false;
		return true;
	}

}