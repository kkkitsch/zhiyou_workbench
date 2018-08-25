package com.kkk.other;

//题目：打印出所有的"水仙花数"
public class ShuiXianHua {
	public static void main(String[] args) {
		int i,j,k;
		for(int a=101;a<=999;a++)
		{
			int sum=0;
			i=a/100;
			j=(a-i*100)/10;
			k=a%10;
			sum=i*i*i+j*j*j+k*k*k;
			if (sum==a)
			{
				System.out.println(a+"是水仙花数");
			}
			
		}
									//		int sum;      第二种算法
									//	      for(i=1;i<=9;i++){  
									//	          for(j=0;j<=9;j++){  
									//	              for(k=0;k<=9;k++){  
									//	                  sum=i*i*i+j*j*j+k*k*k;  
									//	                  if(i*100+j*10+k==sum){  
									//	                      System.out.println(sum);  
									//	                  }  
									//	              }  
									//	          }  
									//	      }  
	}
}
