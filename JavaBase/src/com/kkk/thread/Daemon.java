package com.kkk.thread;

/*
 * 设置后台进程
 * 以下程序中，如果t1不为后台进程，run()方法就是死循环，但
 * 是将t1设置为后台进程，在所有的非后台进程结束时，后台进程t1页将结束
 */
public class Daemon {
	public static void main(String[] args) {
		DaemonDemo d1 = new DaemonDemo();
		Thread t1 = new Thread(d1, "kkk");
		if (t1.isDaemon()) {
			t1.start();
		}
	}
}

class DaemonDemo implements Runnable {
	public void run() {
		int i = 0;
		while (true) {
			System.out.println("i=" + i);
		}
	}
}
