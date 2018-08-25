package com.kkk.thread;

public class Priority implements Runnable {
	public static void main(String[] args) {

		Priority p1 = new Priority();
		Thread t1 = new Thread(p1, "kkk");
		Thread t2 = new Thread(p1, "aaa");
		Thread t3 = new Thread(p1, "ppp");
		Thread t4 = new Thread(p1, "hhh");

		// 设置线程优先级，值越大，优先级越大
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.NORM_PRIORITY);
		t3.setPriority(Thread.MIN_PRIORITY);
		t4.setPriority(Thread.MAX_PRIORITY);

		// 启动线程
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

	public void run() {
		for (int i = 0; i < 20; i++) {
			System.out.println("当前线程：" + Thread.currentThread().getName() + ",i=" + i);
		}
	}

}
