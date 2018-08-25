package com.kkk.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class PrintStreamDemo {
	/*
	 * PrintStream和PrintWriter的区别 ：一个是操作字节流，一个是操作字符流，对于print系列的方法，两者 没有什么区别
	 * PrintStream有处理字节的方法，PrintWriter有处理 字符的方法
	 */
	@Test
	public void test() {
		OutputStream output = null;
		PrintStream print = null;
		try {
			// 定义一个字节输出流
			output = new FileOutputStream(new File("D:/zy/eclipse/IOWorkBench/PrintStream.txt"));
			// 打印流
			print = new PrintStream(output);
			// 将默认显示在控制台上的信息 改为显示在文件中
			System.setOut(print);
			// 打印输出
			print.println("kitsch");
			print.println(123456);
			print.println(false);
			print.println('c');
			print.println(3.14);
			print.println("这是中文");
			System.out.println("输出成功");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭流
			try {
				if (print != null) {
					print.close();
				}
				if (output != null) {
					output.close();
				}
				System.out.println("关闭流成功");
			} catch (Exception e) {
				System.out.println("关闭流失败");
				e.printStackTrace();
			}
		}
	}
}
