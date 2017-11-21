package algorithm.thingking;

import java.util.Scanner;

/**
 * 利用求鸡兔子的个数理解穷举算法
 * @author lijianfu
 * 2017年11月20日
 * 上午11:44:04
 */
public class QiongJuTest {

	static int chicken, habbit;		//代表鸡的个数和兔子个数
	
	public static int qiongJu(int head, int foot){
		int result = 0;
		for (int i = 0; i < head; i++) {
			
			int j = head - i;
			if (i*2 + j*4 == foot) {
				result = 1;
				chicken = i;
				habbit = j;
			}
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int result, head, foot;
		System.out.println("穷举算法求取鸡兔同笼的问题：");
		System.out.print("请输入头数：");
		Scanner input = new Scanner(System.in);
		head = input.nextInt();
		System.out.print("请输入脚数：");
		foot = input.nextInt();
		result = qiongJu(head, foot);
		if (result == 1) {
			System.out.println("鸡有" + chicken + "只，兔有" + habbit + "只！");
		}else{
			System.out.println("此题无解！");
		}
	}

}
