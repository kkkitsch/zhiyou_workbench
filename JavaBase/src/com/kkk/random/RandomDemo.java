package com.kkk.random;

import java.util.Random;

import org.junit.Test;

public class RandomDemo {

	@Test
	public void testRandom() {
		Random random = new Random();

		// 生成任意一个随机数
		System.out.println(random.nextInt());

		// 返回一个伪随机数，它是取自此随机数生成器序列的、在 0（包括）和指定值（3）之间均匀分布的 int 值
		System.out.println(random.nextInt(3));

		// 生成99次一个[1,3]的随机数
		for (int i = 1; i < 100; i++) {
			System.out.println((random.nextInt(3) + 1));
		}

		// 生成一个[0,1]的随机小数
		System.out.println(random.nextDouble());
	}
}
