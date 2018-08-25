package com.kkk.thread;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
	private static int ticket = 100;
	ReentrantLock lock = new ReentrantLock();

	public ReentrantLockDemo() {
	}

	public static void main(String[] args) {
		SynchronizedMethod s1 = new SynchronizedMethod();
		Thread t1 = new Thread(s1, "kkkitsch");
		Thread t2 = new Thread(s1, "tomcluse");
		t1.start();
		t2.start();
	}

	// 同步锁
	public void run() {
		while (ticket >= 1) {
			// 给以下代码上锁
			lock.lock();
			try {
				Thread.sleep(10);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (ticket > 0) {
				System.out.println(Thread.currentThread().getName() + "卖出第" + ticket-- + "张票");
			}
			// 解锁
			lock.unlock();
		}
	}
}
