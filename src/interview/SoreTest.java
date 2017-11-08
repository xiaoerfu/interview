package interview;

import java.util.Scanner;

/**
 * 对输入的10个数进行排序
 * @author lijianfu
 * 2017年10月20日
 * 下午3:53:42
 */
public class SoreTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = new int[10];
		Scanner s = new Scanner(System.in);
		System.out.println("请输入10个整数：");
		for (int i = 0; i < 10; i++) {
			a[i] = s.nextInt();
		}
		for (int i = 0; i < a.length-1; i++) {
			for (int j = 0; j < a.length-1-i ; j++) {
				if (a[j] > a[j+1]) {
					int t = a[j];
					a[j] = a[j+1];
					a[j+1] = t;
				}
			}
		}
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

}
