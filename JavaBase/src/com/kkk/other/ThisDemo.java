package com.kkk.other;

public class ThisDemo {
	int a = 10;

	public static void main(String[] args) {
		ThisDemo d = new ThisDemo();
		/*
		 * 必须有类的实例才能调用非静态方法
		 */
		d.abc();
	}

	public ThisDemo abc() {
		/*
		 * this表示当前类的对象，由于this表示的是当前类的实例，
		 * 所以this只能在实例方法中使用，不能再静态方法中使用，
		 * this可以表示 :返回调用当前方法的对象,可以用于比较对象是否相等
		 */
		System.out.println(this.a);
		/*
		 * this==new Demo010() this就相当于新建一个匿名当前类
		 */
		System.out.println(new ThisDemo().a);
		return this;
	}
}
