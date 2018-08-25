package com.kkk.thread;

/*
 *没有同步时出现的情况：
	tony卖出第10张票
	kkk卖出第10张票
	tony卖出第9张票
	kkk卖出第8张票
	tony卖出第7张票
	kkk卖出第6张票
	tony卖出第5张票
	kkk卖出第4张票
	tony卖出第3张票
	kkk卖出第2张票
	tony卖出第1张票
	
	
	tony卖出第10张票
	kkk卖出第9张票
	tony卖出第8张票
	kkk卖出第7张票
	kkk卖出第5张票
	tony卖出第6张票
	kkk卖出第4张票
	kkk卖出第2张票
	tony卖出第3张票
	kkk卖出第1张票


 */
public class SaleTicket implements Runnable {
	private static int ticket = 10;
	private String name;

	public static void main(String[] args) {
		SaleTicket s1 = new SaleTicket();
		SaleTicket s2 = new SaleTicket();
		Thread t1 = new Thread(s1, "kkk");
		Thread t2 = new Thread(s2, "tony");
		t1.start();
		t2.start();
	}

	public SaleTicket(String name) {
		setName(name);
	}

	public SaleTicket() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void run() {
		while (ticket >= 1) {
			if (ticket > 0) {
				System.out.println(Thread.currentThread().getName() + "卖出第" + ticket-- + "张票");
			}
		}
	}
}
