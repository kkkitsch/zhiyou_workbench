package com.kkk.thread;

/*
 * 使用 同步方法
 */
public class SynchronizedMethod implements Runnable {
	private static int ticket = 100;

	public SynchronizedMethod() {
	}

	public void run() {
		while (ticket >= 1) {
			this.sale();
		}
	}

	public static void main(String[] args) {
		SynchronizedMethod s1 = new SynchronizedMethod();
		Thread t1 = new Thread(s1, "kkkitsch");
		Thread t2 = new Thread(s1, "tomcluse");
		t1.start();
		t2.start();
	}

	// 使用同步方法：[访问控制符] [static|final] synchronized 返回类型 方法名(参数列表)
	public synchronized void sale() {
		if (ticket > 0) {
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "卖出第" + ticket-- + "张票");
		}
	}
}
