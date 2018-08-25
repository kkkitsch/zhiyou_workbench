package com.kkk.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import org.junit.Test;

public class InputStreamReaderDemo {
	@Test
	public void testISR() throws Exception {
		// 定义一个文件实例
		File file = new File("D:/zy/eclipse/IOWorkBench/InputStreamReader.txt");
		// 定义一个字节输入流
		FileInputStream fin = new FileInputStream(file);
		// 定义一个转换流
		InputStreamReader isr = new InputStreamReader(fin);
		System.out.println("系统默认字符：" + isr.getEncoding());
		char c[] = new char[(int) file.length()];
		isr.read(c);
		isr.close();
		fin.close();
		System.out.println(new String(c));
	}
}
