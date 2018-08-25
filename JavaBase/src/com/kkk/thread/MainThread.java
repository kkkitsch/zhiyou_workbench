package com.kkk.thread;

/*
 * java应用程序的main方法是它的主线程当java程序启动时，一个主线程自动被创建 并运行，
 * 执行的进入点 就是 main方法，可以视为是主线程的run方法
 * 
 * 一个java程序运行至少会启动两个线程，一个是jvm的垃圾收集线程，一个是主线程
 */
public class MainThread implements Runnable {

	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("当前运行的线程：" + Thread.currentThread() + ",i=" + i);
		}
	}

	public static void main(String[] args) {

		// 获取main主线程
		Thread main = Thread.currentThread();
		System.out.println("线程信息：" + main);
		System.out.println("线程名称：" + main.getName());
		main.setName("main-define");
		System.out.println("线程名称：" + main.getName());

		MainThread m1 = new MainThread();
		Thread define = new Thread(m1);

		// 启动main线程，define线程
		define.start();
		// 直接调用main方法
		m1.run();
	}
}
