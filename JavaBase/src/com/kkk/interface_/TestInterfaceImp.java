package com.kkk.interface_;

public class TestInterfaceImp implements TestInterface {

	public static void main(String[] args) {
		TestInterface test = new TestInterfaceImp();
		test.test1();
		test.test2();
	}

	@Override
	public void test1() {
		System.out.println("test1");

	}

	@Override
	public int test2() {
		System.out.println("test2");
		return 0;
	}

}
