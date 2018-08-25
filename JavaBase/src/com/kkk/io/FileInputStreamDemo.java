package com.kkk.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.junit.Test;

public class FileInputStreamDemo {

	// 读取文件，存到缓冲区，不能读取中文，如果有中文，显示乱码
	@Test
	public void testFileInputStream() {
		// 创建一个文件
		File file = new File("D:/zy/eclipse/IOWorkBench/FileInputStream.txt");
		InputStream input = null;
		// 创建一个缓冲区
		byte[] b = new byte[(int) file.length()];
		try {
			// 实例化input
			input = new FileInputStream(file);
			// 把file文件读取到缓冲区
			input.read(b);
			// 关闭input
			input.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 将缓冲区的数据输出
		System.out.println(new String(b));
	}

	// 第二种读取文件的方式：一个字节一个字节的读，不能读取中文，如果有中文，显示乱码
	@Test
	public void testFileInputStream2() {
		// 创建一个文件
		File file = new File("D:/zy/eclipse/IOWorkBench/FileInputStream.txt");
		InputStream input = null;
		// 创建一个缓冲区
		byte[] b = new byte[(int) file.length()];
		try {
			// 实例化input
			input = new FileInputStream(file);
			int temp = 0;
			int len = 0;
			// 一个一个的读取文件内容，赋值给temp，如果!=-1，表示没有到达文件末尾
			while ((temp = input.read()) != -1) {
				System.out.println("读取返回的是字节的int型(取值范围：0-255)=====" + temp);
				b[len++] = (byte) temp;
			}
			// 关闭input
			input.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 将缓冲区的数据输出
		System.out.println(new String(b));
	}
}
