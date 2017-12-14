package search;

import java.util.Scanner;

/**
 * 顺序查找算法
 * @author lijianfu
 * 2017年11月21日
 * 下午2:40:11
 */
public class OrderSearchTest {

	static final int N = 15;
	
	static int searchFun(int a[], int n, int x){
		int f = -1;
		for (int i = 0; i < a.length; i++) {
			if (x == a[i]) {
				f = i;
				break;
			}
		}
		return f;

	}
	public static void main(String[] args) {
		int x, n;
		int arr[] = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random()*(100+1) + 100);
		}
		
		System.out.println("顺序查找演示：");
		System.out.println("数据序列为：");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		System.out.print("请输入要查找的数：");
		Scanner input = new Scanner(System.in);
		x = input.nextInt();
		
		n = searchFun(arr, N, x);
		
		if (n < 0) {
			System.out.println("没有找到数据");
		}else{
			System.out.println("数据" + x + "位于数组的第" + (n+1) + "位");
		}
	}

}
