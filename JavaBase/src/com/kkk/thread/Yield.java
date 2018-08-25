package com.kkk.thread;

/*
 * 线程的礼让
 * 
 * 运行可以从结果看出，thread1要比thread2运行的几率小，因为它礼让其他线程
 * 
 * sleep()和yield()方法的比较：
	 * sleep():让出运行权时，不考虑其他线程的优先级
	 * yield():让出运行权时，只将运行权让给与其有相同优先级的或者优先级更高的
	 * 
	 * sleep()会让当前线程转到阻塞状态
	 * yield()会让当前线程转到就绪状态
	 * 
	 * sleep()声明抛出InterruptException异常
	 * yield()不抛出任何异常
	 * 
	 * sleep()比yield()具有更好的移植性
	 * 
	 * 
 *sleep()和wait()方法的异同
	 *sleep()和wait()方法都会让出CPU运行权，让当前现场进入阻塞状态
	 *sleep()方法属于Thread类，是静态方法，wait()方法是Object类的实例方法
	 *定义sleep()方法，必须设置时间长度，wait()方法可以设定，页可以不设定
	 *执行sleep()方法，可用interrupt()方法将其唤醒，执行wait()方法，可用notify(),notifyAll()将其唤醒
	 *若现场T拥有对象O的对象锁，当T执行sleep()方法后，线程T将进入对象O的锁池中，但是不会释放对象O的锁，而执行wait()
	 *方法后，线程A将进入对象O的等待池，并释放O的锁，等待被唤醒后进入O的锁池，在等待获取对象O的锁和运行权 
 */
public class Yield {
	public static void main(String[] args) {
		Thread1 t1 = new Thread1();
		Thread2 t2 = new Thread2();

		Thread thread1 = new Thread(t1, "kkk");
		Thread thread2 = new Thread(t2, "hhh");

		thread1.start();
		thread2.start();
	}

}

class Thread1 implements Runnable {

	public void run() {
		for (int i = 0; i < 20; i++) {
			System.out.println("当前线程：" + Thread.currentThread().getName() + ",i=" + i);
			// 线程的礼让，礼让其他线程
			Thread.yield();
		}
	}
}

class Thread2 implements Runnable {

	public void run() {
		for (int i = 0; i < 20; i++) {
			System.out.println("当前线程：" + Thread.currentThread().getName() + ",i=" + i);
		}
	}
}