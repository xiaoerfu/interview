package interview;

import java.util.Scanner;

/**
 * 有一对兔子，从出生后第三个月起每个月都生一对兔子，小兔子长到第三个月后
 * 每一个月又生一对兔子，假如兔子都不死，问每个月的兔子总数为？斐波那契数列
 * 利用递归的思想解决：F(0)=0; F(1)=1; F(n)=F(n-1)+F(n-2)(n>=2,n∈N);
 * @author lijianfu
 *
 */
public class TuziTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("第一种方法");
		System.out.println("第1个月的兔子对数为：1");
		System.out.println("第2个月的兔子对数为：1");
		int f1 = 1;
		int f2 = 1;
		int f;
		int M = 24;
		for (int i = 3; i <= M; i++) {
			f = f2;
//			System.out.println(f);
			f2 = f1 + f2;
			f1 = f;
//			System.out.println(f1);
			System.out.println("第" + i + "个月的兔子对数  ：" + f2);
		}
		System.out.println("----------------------");
		System.out.println("第二种方法");
		 long [] m ;
	        System.out.print("Please input month : ");
	        //键盘输入月数
	        Scanner s = new Scanner(System.in);
	        int i = s.nextInt();
	        m = new long[i];

	        if(m.length >= 1){
	            m[0] = m[1] = 1;//第一和第二个月的兔子都是：1
	        }
	        for(int j = 0; j < m.length; j++){
	            if(j == 0 || j == 1){
	                System.out.println("Month : " + (j+1) + "\tRabbit number is : " + m[j]);
	            }else {
	                m[j] = m[j-2] + m[j-1];//第三个月以后都满足规律：m[j] = m[j-2] + m[j-1]
	                System.out.println("Month : " + (j+1) + "\tRabbit number is : " + m[j]);
	            }
	        }
	}

}
