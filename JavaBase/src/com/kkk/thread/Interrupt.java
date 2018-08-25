package com.kkk.thread;

import java.util.Date;

/*
 * 判断线程中断的方法：
 * isInterrupted():是，返回true，否，返回false，线程的中断状态不受该方法影响
 * interrupted():是，返回true，否，返回false，线程的中断状态被消除
 */
public class Interrupt {
	public static void main(String[] args) {
		InterruptDemo i1 = new InterruptDemo();
		Thread t1 = new Thread(i1, "kitsch");
		t1.start();
		try {
			t1.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 将休眠的线程唤醒会抛出异常
		t1.interrupt();
	}
}

class InterruptDemo implements Runnable {
	public void run() {
		System.out.println("开始运行run方法的时刻：" + new Date());
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			System.out.println("线程被唤醒");
		}
		System.out.println("结束运行run方法的时刻：" + new Date());
	}
}