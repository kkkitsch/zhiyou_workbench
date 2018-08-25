package com.kkk.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/*
 *首先创建线程池，初始状态corePoolSize为5，最多maximumPoolSize为10，BlockingQueue为5
 *
 *首先执行前五个任务，再有任务时，放到阻塞队列中，阻塞队列中满了以后，还有任务，就开始执行补救措施，执行最多maximumPoolSize，表示同时可最多执行
 *10个任务，所以执行顺序为：
 *
 *
			正在执行task 1
			线程池中线程数目：1，队列中等待执行的任务数目：0，已执行玩别的任务数目：0
			线程池中线程数目：2，队列中等待执行的任务数目：0，已执行玩别的任务数目：0
			线程池中线程数目：3，队列中等待执行的任务数目：0，已执行玩别的任务数目：0
			正在执行task 3
			正在执行task 2
			线程池中线程数目：4，队列中等待执行的任务数目：0，已执行玩别的任务数目：0
			正在执行task 4
			线程池中线程数目：5，队列中等待执行的任务数目：0，已执行玩别的任务数目：0
			线程池中线程数目：5，队列中等待执行的任务数目：1，已执行玩别的任务数目：0
			正在执行task 5
			线程池中线程数目：5，队列中等待执行的任务数目：2，已执行玩别的任务数目：0
			线程池中线程数目：5，队列中等待执行的任务数目：3，已执行玩别的任务数目：0
			线程池中线程数目：5，队列中等待执行的任务数目：4，已执行玩别的任务数目：0
			线程池中线程数目：5，队列中等待执行的任务数目：5，已执行玩别的任务数目：0
			线程池中线程数目：6，队列中等待执行的任务数目：5，已执行玩别的任务数目：0
			正在执行task 11
			线程池中线程数目：7，队列中等待执行的任务数目：5，已执行玩别的任务数目：0
			正在执行task 12
			线程池中线程数目：8，队列中等待执行的任务数目：5，已执行玩别的任务数目：0
			正在执行task 13
			线程池中线程数目：9，队列中等待执行的任务数目：5，已执行玩别的任务数目：0
			正在执行task 14
			线程池中线程数目：10，队列中等待执行的任务数目：5，已执行玩别的任务数目：0
			正在执行task 15
			
			------------------------------------------------------
			
			task 1执行完毕
			正在执行task 6
			task 2执行完毕
			正在执行task 7
			task 4执行完毕
			task 3执行完毕
			task 5执行完毕
			正在执行task 9
			正在执行task 8
			正在执行task 10
			task 15执行完毕
			task 11执行完毕
			task 12执行完毕
			task 13执行完毕
			task 14执行完毕
			
			------------------------------------------------------
			
			task 6执行完毕
			task 9执行完毕
			task 8执行完毕
			task 7执行完毕
			task 10执行完毕
		
		
		执行前五个线程，task 1，task 2，task 3，task 4，task 5
		---->task 6,task 7,task 8,task 9，task 10线程放到阻塞队列中
		如果还有线程，则启用补救措施，新的线程最多执行五个，执行task 11，task 12，task 13，task 14，task 15
		
		所以，同一时间执行的线程有task 1，task 2，task 3，task 4，task 5，task 11，task 12，task 13，task 14，task 15
			 	    被阻塞的为task 6，task 7，task 8，task 9，task 10
		
		当执行的线程执行完毕后，被阻塞的线程才能执行
 *
 */
public class ThreadPoolTest {
	public static void main(String[] args) {
		ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,
				new ArrayBlockingQueue<Runnable>(5));

		for (int i = 1; i <= 15; i++) {
			MyTask myTask = new MyTask(i);
			executor.execute(myTask);
			System.out.println("线程池中线程数目：" + executor.getPoolSize() + "，队列中等待执行的任务数目：" + executor.getQueue().size()
					+ "，已执行玩别的任务数目：" + executor.getCompletedTaskCount());
		}
		executor.shutdown();
	}
}
