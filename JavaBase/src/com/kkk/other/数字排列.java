package com.kkk.other;
//有1 2 3 4 四个数字   能够组成多少不同的4位数字  各是多少
public class 数字排列 {
	public static void main(String[] args) {
		int a,b,c,d;
		for(a=1;a<5;a++)
		{
			for(b=1;b<5;b++)
			{
				for(c=1;c<5;c++)
				{
					for(d=1;d<5;d++)
					{
						if (a!=b&&a!=c&&a!=d&&b!=c&&b!=d&&c!=d)
						{
							System.out.print(a);
							System.out.print(b);
							System.out.print(c);
							System.out.println(d);
						}
					}
				}
			}
		}
	}
}
////有1 2 3 4 四个数字   能够组成多少不同的3位数字  各是多少
//public class 数字排列 {
//	public static void main(String[] args) {
//		int a,b,c;
//		for(a=1;a<5;a++)
//		{
//			for(b=1;b<5;b++)
//			{
//				for(c=1;c<5;c++)
//				{
//					if (a!=b&&a!=c&&b!=c)
//						{
//							System.out.print(a);
//							System.out.print(b);
//							System.out.println(c);
//					}
//				}
//			}
//		}
//	}
//}