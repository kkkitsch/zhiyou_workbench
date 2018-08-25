package com.kkk.thread;

//Thread类属于lang包，系统运行时自动导入
public class ThreadTest extends Thread {
	public static void main(String[] args) {

		ThreadTest t1 = new ThreadTest("线程1");
		ThreadTest t2 = new ThreadTest("线程2");
		// 启动线程，一个线程对象只能调用一次start方法，多次调用的话会出错
		t1.start();
		t2.start();
	}

	// 不需要重新定义setName和getName方法，因为Thread类中已经定义了final类型的setName和getName方法

	public ThreadTest() {
	}

	public ThreadTest(String name) {
		setName(name);
	}

	// 线程方法
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("当前运行的线程：" + getName() + ",i=" + i);
		}
	}
}
