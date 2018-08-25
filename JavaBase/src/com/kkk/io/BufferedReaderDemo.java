package com.kkk.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;

import org.junit.Test;

public class BufferedReaderDemo {
	@Test
	public void testBufferedReader() {
		// 文件实例
		File file = new File("D:/zy/eclipse/IOWorkBench/BufferedReader.txt");
		Reader reader = null;
		String str = "";
		BufferedReader br = null;
		try {
			// 字符输入流实例
			reader = new FileReader(file);
			// 缓冲流实例
			br = new BufferedReader(reader);
			// 读取一行
			str = br.readLine();
			System.out.println("读取成功！");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
				if (reader != null) {
					reader.close();
				}
				System.out.println("关闭流成功！");
			} catch (Exception e) {
				System.out.println("关闭流失败！");
				e.printStackTrace();
			}
		}
		System.out.println("从文件读取一行内容：" + str);
	}
}
