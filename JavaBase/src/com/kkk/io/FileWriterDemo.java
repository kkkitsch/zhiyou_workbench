package com.kkk.io;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;

import org.junit.Test;

public class FileWriterDemo {
	@Test
	public void testFileWriter() {
		// 定义一个文件实例
		File file = new File("D:/zy/eclipse/IOWorkBench/FileWriter.txt");
		Writer writer = null;
		// 在缓存区定义一个内容
		String str = "这是要写入FileWriter.txt的内容";
		// 转换成字符数组
		char c[] = str.toCharArray();
		try {
			// true表示可以在文件内追加内容
			writer = new FileWriter(file, true);
			// 写入到文件
			writer.write(c);
			// 还可以直接写入字符串的内容到文件，不用转换成字符数组
			// writer.write(str);

			// 文件内容追加
			writer.append("，这是追加的内容！！！");
			System.out.println("写入成功！");
			/*
			 * 在字节流中，不执行close()方法，还是可以向 文件输出内容
			 * 
			 * 在字符流中，不执行close()方法，无法向文件输出内容
			 * 
			 * 为什么：因为字节流是直接对文件本身操作，不需要通过缓冲区，而字符流需要通过缓冲区
			 */
			writer.close();
		} catch (Exception e) {
			System.out.println("写入失败！");
			e.printStackTrace();
		}
	}
}
/*
 * 缓冲区的定义：计算机访问外部设备或文件，要比访问内存慢得多，如果每次调用read()或writer()方法访问外部设备或文件，
 * 那么，CPU就要花费大量的事件去等待外部设备的响应，而不是处理数据，为此，在内存中定义一个缓冲区，程序每次调用read()或writer()方法
 * 都是读取这个缓冲区的内容，当缓冲区的内容被装满后，系统才将缓冲区的内容一次集中写入到 外部设备或读取进来给 CPU，使用缓冲区可以
 * 显著提高CPU利用率，在字符操作流中，所有的字符都是在内存中 形成的，在字符流输出前，都将保存在内存中的缓冲区内
 */
