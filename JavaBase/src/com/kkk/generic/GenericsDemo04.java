package com.kkk.generic;

// 子类GenericsDemo04继承父类Generics04(),传递给子类的泛型对象也会传递给父类
public class GenericsDemo04<T, S> extends Generics04<T> {
	public S a;

	public S getA() {
		return a;
	}

	public void setA(S a) {
		this.a = a;
	}

	public GenericsDemo04(T t, S a) {
		super(t);
		this.a = a;
	}

	@Override
	public String toString() {
		return "GenericsDemo04 [a=" + a + ", getObj()=" + getObj() + "]";
	}

	public static void main(String[] args) {
		GenericsDemo04<Integer, String> gene = new GenericsDemo04<Integer, String>(18, "kitsch");
		System.out.println("ge对象的内容：" + gene);
	}

}

class Generics04<T> // 父类泛型
{
	private T obj;

	public Generics04() {
	}

	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}

	public Generics04(T obj) {
		super();
		this.obj = obj;
	}

}