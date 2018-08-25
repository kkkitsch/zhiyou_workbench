package com.kkk.io;

import java.io.File;
import java.util.Scanner;

import org.junit.Test;

public class FileOperation {

	// 测试类
	@Test
	public void testFile() throws Exception {
		deleteFile();
	}

	// 如果文件存在，就删除文件
	public void deleteFile() throws Exception {
		// 创建文件类实例
		File file = new File("D:/zy/eclipse/IOWorkBench/A (1).txt");
		// 判断文件是否存在
		if (file.exists()) {
			file.delete();
			System.out.println("文件已经删除！");
		} else {
			System.out.println("文件不存在，正在创建......");
			// 创建文件
			createFile(file);
			// 输出此文件父路径下的所有文件
			getAllFile(file);
		}
	}

	// 如果文件不存在，就创建文件
	public void createFile(File file) throws Exception {
		file.createNewFile();
		System.out.println("文件创建成功！");
		// 输出文件的一些属性
		getAttribute(file);
	}

	// 输出文件的一些属性
	public void getAttribute(File file) {
		System.out.println("文件名：" + file.getName());
		System.out.println("文件大小：" + file.length());
		System.out.println("文件路径：" + file.getPath());
		System.out.println("文件路径：" + file.getAbsoluteFile());
		System.out.println("文件父路径：" + file.getParent());
		System.out.println("文件最后修改的时间：" + file.lastModified());
		System.out.println("文件是否可读：" + file.canRead());
	}

	// 输出所有文件
	public void getAllFile(File file) {
		// 通过文件父路径创建一个目录
		File files = new File(file.getParent());

		// 通过list()方法输出目录下的所有文件
		String list[] = files.list();
		System.out.println("==========================");
		for (String string : list) {
			System.out.println(string);
		}

		// 通过listFile()方法输出目录下的所有文件
		File[] listFile = files.listFiles();
		System.out.println("==========================");
		for (File file2 : listFile) {
			System.out.println(file2);
		}
	}

	// 创建目录
	@Test
	public void mkdir() {
		// 创建一个单级目录
		File file1 = new File("D:/zy/eclipse/IOWorkBench/mkdirTest");
		// 判断目录是否存在
		if (file1.exists()) {
			file1.delete();
			System.out.println("目录删除成功！");
		} else {
			// 判断目录是否创建成功
			if (file1.mkdir()) {
				System.out.println("单级目录创建成功");
			} else {
				System.out.println("单级目录创建失败");
			}
		}
		// 创建一个多级目录
		File file2 = new File("D:/zy/eclipse/IOWorkBench/mkdirsTest/aaa/bbb/ccc");
		// 判断目录是否存在
		if (file2.exists()) {
			file2.delete();
			System.out.println("目录删除成功！");
		} else {
			// 判断目录是否创建成功
			if (file2.mkdirs()) {
				System.out.println("多级目录创建成功");
			} else {
				System.out.println("多级目录创建失败");
			}
		}
	}

	// 给定一个路径，如果是文件，输出文件名，如果是目录，输出目录下的所有文件和目录
	@Test
	public void testFile2() {
		System.out.println("请输入路径：");
		Scanner sc = new Scanner(System.in);
		showFile(new File(sc.next()));
		sc.close();
	}

	public void showFile(File paramFile) {
		File file = paramFile;
		if (file.isFile()) {
			System.out.println("\t" + file.getPath() + "为文件");
		} else if (file.isDirectory()) {
			System.out.println(file.getPath() + "为目录");
			File[] files = file.listFiles();
			for (File file2 : files) {
				showFile(file2);
			}
		}
	}

}
