package com.kkk.io;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;

import org.junit.Test;

public class FileReaderDemo {
	@Test
	public void testFileReader() {
		// 定义一个文件实例
		File file = new File("D:/zy/eclipse/IOWorkBench/FileReader.txt");
		Reader reader = null;
		// 定义一个缓冲区
		char c[] = new char[(int) file.length()];
		try {
			reader = new FileReader(file);
			// 读取文件（如果读取的中文还是乱码，说明文件的字符编码和eclipse设置的编码不一致）
			reader.read(c);
			System.out.println("文件读取成功");
			reader.close();
		} catch (Exception e) {
			System.out.println("文件读取失败");
			e.printStackTrace();
		}
		System.out.println(new String(c));
	}

	@Test // 一个一个的读取
	public void testFileReader1() {
		// 定义一个文件实例
		File file = new File("D:/zy/eclipse/IOWorkBench/FileReader.txt");
		Reader reader = null;
		// 定义一个缓冲区
		char c[] = new char[(int) file.length()];
		int temp = 0;
		int len = 0;
		try {
			reader = new FileReader(file);
			while ((temp = reader.read()) != -1) {
				// 读取文件（如果读取的中文还是乱码，说明文件的字符编码和eclipse设置的编码不一致）
				c[len++] = (char) temp;
				System.out.println("读取返回的是字符的int型（取值范围0-2的16次方）=====" + temp);
			}
			System.out.println("文件读取成功");
			reader.close();
		} catch (Exception e) {
			System.out.println("文件读取失败");
			e.printStackTrace();
		}
		System.out.println(new String(c));
	}
}
