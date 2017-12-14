package algorithm;

import java.util.Scanner;

/**
 * 自守数：如果一个正整数的平方的末尾几位数等于这个数本身，则这个数是自守数
 * @author lijianfu
 * 2017年11月30日
 * 下午2:38:14
 */
public class ZishouNumTest {

	public static void main(String[] args) {
		 Scanner input=new Scanner(System.in); 
		 System.out.print("请输入自己的数值：");
	        long x=input.nextInt();  
	        if(ziShou(x)==1){  
	            System.out.println("您输入的数"+x+"是自守数");  
	        }else{  
	            System.out.println("您输入的得数"+x+"不是自守数");  
	        }  
	        System.out.println("以下是1000以内自守数");  
	        for(int i=2;i<10000;i++){  
	            if(ziShou(i)==1){  
	                System.out.print(i+" ");  
	        }}  
	}
	
	public static int ziShou(long n){
		long temp, k, m;
		int count;
		k = 1;
		count = 0;
		while (k > 0) {
			k = n - (long)Math.pow(10, count);				//判断位数
			count++;
		}
		m = count - 1;										//位数
		temp = (long) ((n * n) % Math.pow(10, m));
		if (n == temp) {									//判断是否为自守数
			return 1;
		}
		return 0;
	}

}
