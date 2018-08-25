package com.kkk.other;

//题目：判断素数，并输出所有素数。 

//素数又叫质数，就是除了1和它本身之外，再也没有整数能被它整除的数。也就是素数只有两个因子。
public class SuShu 
{
	public static void main(String[] args) 
	{
		int i,n;
		for (n = 3; n<=10000; n++)  //3~1000的所有数
		{    
			i=2;
			while (i<n)
			{
				if (n%i==0)        //若能整除说明n不是素数，跳出当前循环
				{
					break;
				}
				i++;
			}
			if (i==n) //如果i==n则说明n不能被2~n-1整除，是素数
			{
				System.out.println(i);
			}
        }
	}
}