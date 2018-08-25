package com.kkk.error;

public class Test {

	public static void start() throws Exception {
		System.out.println("Java Exception interivew question Answers for Programmers");
		throw new UnsupportedOperationException("t");
	}

	public static void main(String args[]) {
		try {
			start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}