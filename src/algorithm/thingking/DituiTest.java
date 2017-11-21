package algorithm.thingking;

import java.util.Scanner;

/**
 * 利用递推算法求兔子产子的问题(斐波纳契)
 * @author lijianfu
 * 2017年11月20日
 * 下午1:27:41
 */
public class DituiTest {

	public static long fibonacci(int n){
		long t1, t2;
		if (n==1 || n==2) {
			return 1;
		}else{
			t1 = fibonacci(n-1);				//递归调用
			t2 = fibonacci(n-2);
			return t1 + t2;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("递归算法求解兔子产子问题：");
		System.out.print("请输如你想几月后知道兔子有多少只:");
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		long num = fibonacci(n);
		System.out.println("经过" + n + "月后，兔子的总数为：" + num);
	}

}
