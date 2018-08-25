package com.kkk.thread;

/*
 * 通过实现Runnable接口实现线程，
 * 由于Runnable接口没有任何对线程的支持，因此在获得线程实例后，必须通过Thread类的构造方法来实现
 * */
public class CreateThreadImpRunnable implements Runnable {

	private String name;

	public CreateThreadImpRunnable() {
	}

	public CreateThreadImpRunnable(String name) {
		setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("当前运行的线程：" + getName() + ",i=" + i);
		}
	}

	public static void main(String[] args) {
		CreateThreadImpRunnable c1 = new CreateThreadImpRunnable("线程1");
		CreateThreadImpRunnable c2 = new CreateThreadImpRunnable("线程2");
		// 创建线程对象
		Thread t1 = new Thread(c1);
		Thread t2 = new Thread(c2);
		Thread t3 = new Thread(c1);
		Thread t4 = new Thread(c2);
		// 启动线程
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
