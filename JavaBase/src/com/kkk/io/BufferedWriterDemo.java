package com.kkk.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import org.junit.Test;

public class BufferedWriterDemo {
	@Test
	public void testBufferedWriter() {
		// 文件实例
		File file = new File("D:/zy/eclipse/IOWorkBench/BufferedWriter.txt");
		FileWriter writer = null;
		BufferedWriter bw = null;
		// 内存中的数据
		String[] str = { "可乐", "柠檬", "柚子茶" };
		try {
			// 字符输出流实例
			writer = new FileWriter(file);
			// 缓冲流实例
			bw = new BufferedWriter(writer);
			// 迭代输出到文本，并换行
			for (String string : str) {
				bw.write(string);
				bw.newLine();
			}
			System.out.println("输出成功");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭流
			try {
				if (bw != null) {
					bw.close();
				}
				if (writer != null) {
					writer.close();
				}
				System.out.println("关闭流成功");
			} catch (Exception e) {
				System.out.println("关闭流失败！");
				e.printStackTrace();
			}
		}
	}
}
