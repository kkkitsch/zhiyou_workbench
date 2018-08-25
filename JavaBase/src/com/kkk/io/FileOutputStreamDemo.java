package com.kkk.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.junit.Test;

public class FileOutputStreamDemo {
	// 输入内存中的数据到文件中
	@Test
	public void testFileOnputStream() {
		// 创建一个文件实例
		File file = new File("D:/zy/eclipse/IOWorkBench/FileOutputStream.txt");
		OutputStream output = null;
		// 在 内存中创建一个字符串
		String str = "this is a string ,which is write to file\r\n";
		// 将字符串转换成字节数组
		byte[] b = str.getBytes();
		try {
			// 实例化output，并且允许文件的append操作
			output = new FileOutputStream(file, true);
			// 写入文件中
			output.write(b);
			System.out.println("写入成功！");
			output.close();
		} catch (Exception e) {
			System.out.println("写入失败！");
			e.printStackTrace();
		}
	}
}
