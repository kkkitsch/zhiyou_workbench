package com.kkk.generic;

/**
 * 关于static与泛型之间的联系
 */
public class GenericsDemo02 {
	public static void main(String[] args) {
		Generics02<String, Integer> g1 = new Generics02<String, Integer>("刘利合", 21); // 创建Generics类的实例
		g1.show(); // 调用方法输出对象信息
		Generics02.fun(g1); // 重写toString方法 输出对象信息
	}
}

class Generics02<T, S> {
	private T obj1;
	private S obj2;

	public Generics02() {

	}

	public Generics02(T obj1, S obj2) {
		this.obj1 = obj1;
		this.obj2 = obj2;
	}

	public T getObj1() {
		return obj1;
	}

	public void setObj1(T obj1) {
		this.obj1 = obj1;
	}

	public S getObj2() {
		return obj2;
	}

	public void setObj2(S obj2) {
		this.obj2 = obj2;
	}

	public void show() {
		System.out.println("姓名：" + getObj1() + "，年龄：" + getObj2());
	}

	public static <T, S> void fun(Generics02<T, S> g) {
		System.out.println("fun():" + g);
	}

	// public static void fun(Generics02<T,S> g) 解释： 对于static
	// 方法而言，是无法访问泛型类的类型参数的，因此，
	// { 如果想让static方法具有泛型能力，就必须使其成为泛型方法 和上面的fun方法比较！！！
	// System.out.println("fun():"+g);
	// }
	public String toString() {
		return "姓名：" + getObj1() + ",年龄：" + getObj2();
	}

}