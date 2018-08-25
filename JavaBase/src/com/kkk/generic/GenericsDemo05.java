package com.kkk.generic;

import org.junit.Test;

/*
 * 关于泛型与接口 注意事项：如果泛型接口声明为：
 * 
 * interface InterGenerics<T extends Serializable> 
 * 
 * 则实现类必须声明为：class Generics<T extends Serializable> implements InterGenerics<T>
 * 
 * 若实现类声明为：class Generics<T extends Serializable> implements InterGenerics<T extends Serializable>,则编译无法通过
 */
public class GenericsDemo05 {

	@Test
	public void test() {
		Generics05<Integer> gene = new Generics05<Integer>(1996);
		System.out.println("对象内容：" + gene.show());
	}
}

interface InterGenerics05<T> // 泛型接口
{
	public static final int a = 1024;// 全局常量 ， public static final

	// public static final T B=1024; //不能使用泛型来定义全局常量

	public abstract T show(); // 泛型方法
}

class Generics05<T> implements InterGenerics05<T> {

	private T obj;

	public Generics05() {
	}

	public Generics05(T obj) {
		setObj(obj);
	}

	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}

	public T show() {
		return getObj();
	}
}