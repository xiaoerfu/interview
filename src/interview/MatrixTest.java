package interview;

import java.util.Scanner;

/**
 * 求从键盘输入的3*3数组对角线的值
 * @author lijianfu
 * 2017年10月20日
 * 下午4:52:26
 */
public class MatrixTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int a[][] = new int[3][3];
		System.out.println("请输入9个整数：");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				a[i][j] = s.nextInt();
			}
		}
		System.out.println("输入的3*3的矩阵是：");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		//求对角线的sum值
		int sum = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == j) {
					sum += a[i][j];
				}
			}
		}
		System.out.println("3*3数组的对角线值为：" + sum);
	}

}
