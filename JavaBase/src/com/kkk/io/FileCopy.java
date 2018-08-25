package com.kkk.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

import org.junit.Test;

public class FileCopy {
	@Test
	public void test() {
		Scanner sc = new Scanner(System.in);
		// 定义缓冲区的大小，来确定是高速版本还是普通版本
		int cache = 0;
		while (true) {
			System.out.println("请选择版本：\n\t1、高速版本\n\t2、普通版本\n\t3、退出");
			System.out.println("请输入选项：");
			int num = sc.nextInt();
			if (num == 3) {
				System.out.println("程序退出");
				System.exit(0);
			}
			// file文件
			File file1 = new File("D:/zy/eclipse/IOWorkBench/FileCopy1.txt");
			File file2 = new File("D:/zy/eclipse/IOWorkBench/FileCopy2.txt");
			// 判断源文件是否存在
			if (file1.exists()) {
				// 判断缓冲区的大小
				switch (num) {
				case 1: {
					cache = 1024;
					speed(file1, file2, cache);
					break;
				}
				case 2: {
					cache = 512;
					speed(file1, file2, cache);
					break;
				}

				default:
					System.out.println("没有该选项！");
				}
			} else {
				System.out.println("源文件不存在！");
			}
		}
	}

	// 复制文件方法
	public void speed(File file1, File file2, int cache) {
		// 文件开始复制时间
		long startTime = System.currentTimeMillis();
		InputStream input = null;
		OutputStream output = null;
		try {
			int len = 0;
			input = new FileInputStream(file1);
			output = new FileOutputStream(file2);
			// 缓冲区大小
			byte[] b = new byte[cache];
			/*
			 * 核心代码，将文件读取到缓冲区b中，判断是否不等于-1，如果不等于-1，那么，就将缓冲区中的数据写入到文件file2中
			 * len:文件读取时，会返回一个int值，即文件的大小，随着文件读取的进行，len的值会不断增大
			 * 当文件读取完成后，会返回int值为-1，即读取结束
			 * 
			 * 重要： 当在read()方法中给定了缓冲区大小后，读取操作便会将读取的数据放到缓冲区中，写入文件的时候， 将缓冲
			 * 区的数据写入文件当缓冲区满的时候，执行判断语句体中的语句，再次从 缓冲区读的时候，read()返回的int值又从
			 * 头开始(看输出时的len值)，判断语句体中的语句执行的次数少，所以，这种速度快
			 * 不在read中给定缓冲区大小，那么，input的读取操作就是读取一个字符，判断是否等于-1，如果不等于，
			 * 接着执行判断语句体中的内容，当读取下一个字符的时候，再判断是否等于-1，如果不等于，再接着执行判断语句体中的内容，这种方式很慢
			 */
			while ((len = input.read(b)) != -1) {
				output.write(b, 0, len);
				System.out.println("文件复制成功！"+len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				output.close();
				input.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		long endTime = System.currentTimeMillis();
		float fileB = (float) file1.length();
		float fileKB = (float) fileB / 1024;
		// System.currentTimeMillis()返回的是1970年至今的毫秒数
		float executeTime = endTime - startTime;
		System.out.println("花费时间：" + executeTime / 1000 + "s");
		// 文件大小：1KB=1024B
		System.out.println("文件大小：" + fileKB + "KB");
		// 文件复制速度
		float speed = (float) (fileKB / 1024 / executeTime * 1000);
		System.out.println("速度：" + speed + "M/s");
	}
}
