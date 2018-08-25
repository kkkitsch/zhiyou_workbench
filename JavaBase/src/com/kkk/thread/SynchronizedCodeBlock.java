package com.kkk.thread;

public class SynchronizedCodeBlock implements Runnable {
	private static int ticket = 100;

	public SynchronizedCodeBlock() {
	}

	public static void main(String[] args) {
		SynchronizedCodeBlock s1 = new SynchronizedCodeBlock();
		Thread t1 = new Thread(s1, "kkkitsch");
		Thread t2 = new Thread(s1, "tomcluse");
		t1.start();
		t2.start();
	}

	// 同步代码块
	public void run() {
		while (ticket >= 1) {
			synchronized (this) {
				try {
					Thread.sleep(10);
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (ticket > 0) {
					System.out.println(Thread.currentThread().getName() + "卖出第" + ticket-- + "张票");
				}
			}
		}
	}
}
