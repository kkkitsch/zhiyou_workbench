package com.kkk.thread;

import java.util.Date;

/*
 * 线程的加入
 * 
 * 假设在当前运行线程为A中调用线程B的join方法：
	 * 如果没有在join方法中指定时间，则线程A会等到线程B结束后，才从阻塞状态变为就绪状态，等待获取CPU
	 * 如果没有在join方法中指定了时间长度，线程B没有结束，则线程A也会在时间结束时，从阻塞状态变为就绪状态
	 * 如果没有在join方法中指定了时间长度，且时间长度超过了B的运行时间，则线程A会在线程B运行结束时，从阻塞状态变为就绪状态
 */
public class Join {
	public static void main(String[] args) {
		ThreadDemo td1 = new ThreadDemo();
		Thread t1 = new Thread(td1, "kkkitsch");
		Thread main = Thread.currentThread();
		t1.start();
		for (int i = 1; i <= 10; i++) {
			if (i == 5) {
				try {
					main.join(3000);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			System.out.println("当前运行的线程：" + Thread.currentThread().getName() + "，i=" + i + "，时间：" + new Date());
		}
	}
}

class ThreadDemo implements Runnable {
	public void run() {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (int i = 0; i <= 5; i++) {
			System.out.println("当前运行的线程：" + Thread.currentThread().getName() + "，i=" + i + "，时间：" + new Date());
		}
	}

}