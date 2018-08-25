package com.kkk.other;


public class ArrayUseDemo {
	public static void main(String[] args) {
		//数组的使用规范
		//方式--<1>
		int arr[]=null;
		arr=new int[5];
		//方式--<2>
		int arr1[] =new int[5];
		//数组的静态初始化--<1>
		int arr2[]={1,3,5};
		//数组的静态初始化--<2>
		int arr3[]=new int[]{1,2,3,4,5};
		//数组的动态初始化
		int arr4[]=new int[3];
		arr4[0]=1;
		arr4[1]=2;
		arr4[2]=3;
		System.out.println(arr4[1]);//索引超出数组范围  编译并不会报错
		for(int a:arr4)             //foreach遍历 ：  foreach(数据类型    变量名:数组名){}
		{
			System.out.print(a+" ");
		}
		System.out.println();
		//二维数组的使用
		int arr9[][]=new int[4][2];
		arr9=new int[][]{{1,1},{2,2},{3,3},{4,4}};
		int i=0;
		System.out.println(arr9[3].length);  //二维数组中对于列的获取
		
//		//错误使用数组--<1>
//		int arr5[]=new int[5]{1,2,3,4,5};
//		//错误使用数组--<2>
//		int arr6[]=new int[3];
//		arr6={1,2,3};
//		//错误使用数组--<3>
//		byte arr7[]=new byte[]{1,2,128};  //128超出byte数据类型范围
//		//错误使用数组--<4>
//		byte arr8[]=new int[]{1,2,3};     //数据类型不一样
		
		
	}
}
