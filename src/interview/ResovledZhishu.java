package interview;

import java.util.Scanner;

/**
 * 分解质数，例如：输入90，打印出90=2*3*3*5
 * @author lijianfu
 *
 */
public class ResovledZhishu {

	public static void main(String[] args) {
		// 从键盘输入所需要分解的正整数
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入一个正整数");
		int n = scanner.nextInt();
		
		factor(n);
		
	}
	
	//函数：进行分解质因数
	static void factor(int number){
		for (int i = 2; i <= number; i++) {
			if(number%i == 0){
				System.out.print(i + " ");
				//判断number/i是不是素数，如果是素数就直接输出
				if (isPrime(number/i)) {
					System.out.print(number/i + " ");
				}else{
					factor(number/i);
				}
				return;
			}
		}
	}

	private static boolean isPrime(int i) {
		// TODO Auto-generated method stub
		for (int j = 2; j < i; j++) {
			if(i%j == 0){
				return false;
			}
		}
		return true;
	}

}
