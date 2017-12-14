package algorithm.game;

import java.util.Scanner;

/**
 * 汉诺塔三部曲
 * 1、A柱子把共“n-1”个盘借助C盘移动到B盘，完成一个大过程
 * 2、A柱子把剩下的"第n"个盘子直接移动到C盘，完成一个大过程
 * 3、B柱子上的"共n-1"个盘借助A移动到C盘，又完成一个大过程
 * @author lijianfu
 * 2017年12月1日
 * 上午9:58:50
 */
public class HanoiTest {

	static long count;
	static void hanoi(int n, char a, char b, char c){		//a,b,c所代表：原->辅助->目标
		if (n == 1) {
			//只有一个时,原柱子->目标柱子
			System.out.printf("第%d次移动：\t圆盘从%c棒移动到%c棒\n",
					++count, a, c);
		}else{
			//1、第一步是A借C把（n-1）个移动到B
			//所以C变成辅助位，排在第二位，B就是目标位置
			hanoi(n-1, a, c, b);						//递归调用
			System.out.printf("第%d次移动：\t圆盘从%c棒移动到%c棒\n",
					++count, a, c);
			
			//B借助A把（n-1）个移动到C
			//A就变成是辅助，所以排在第二位置，C就是目标位置
			hanoi(n-1, b, a, c);						//递归调用
		}
	}
	public static void main(String[] args) {

		int n;											//圆盘数量
		count = 0;
		System.out.println("汉诺塔问题求解！");
		System.out.printf("输入汉诺塔盘数：");
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		hanoi(n, 'A', 'B', 'C');
		System.out.println("求解完毕，需要移动" + count + "步移动！");
	}

}
