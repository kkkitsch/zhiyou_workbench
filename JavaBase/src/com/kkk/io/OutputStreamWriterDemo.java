package com.kkk.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import org.junit.Test;

public class OutputStreamWriterDemo {
	@Test
	public void test() throws Exception {
		// 定义一个文件实例
		File file = new File("D:/zy/eclipse/IOWorkBench/OutputStreamWriter.txt");
		// 定义一个字节输出流实例
		FileOutputStream fos = new FileOutputStream(file);
		// 定义一个转换流实例
		OutputStreamWriter osw = new OutputStreamWriter(fos);
		// 在内存中定义 数据
		String str = "向OutputStreamWriter.txt输出内容";
		// 输出数据
		osw.write(str);
		System.out.println("输出 成功");
		osw.close();
		fos.close();
	}
}
