package com.kkk.enum_;

/*
 * 枚举类与接口
 */
public class EnumDemo02 {
	public static void main(String[] args) {
		for (Directions02 dir : Directions02.values()) {
			System.out.println(dir);
		}
	}
}

interface DirInterface {
	public abstract void show();
}

enum Directions02 implements DirInterface {
	EAST() // 每个枚举成员必须实现所有抽象方法！！！
	{
		public void show() {
			System.out.println("EAST");
		}
	}, // 是逗号！！！
	WEST() {
		public void show() {
			System.out.println("WEST");
		}
	},
	SOUTH() {
		public void show() {
			System.out.println("SOUTH");
		}
	},
	NORTH() {
		public void show() {
			System.out.println("NORTH");
		}
	};
}