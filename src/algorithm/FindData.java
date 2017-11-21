package algorithm;

import java.util.Random;
import java.util.Scanner;

/**
 * 查找一个对应的数值
 * @author lijianfu
 * 2017年11月15日
 * 上午9:21:43
 */
public class FindData {

	static int N = 20;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[N];
		int n;
		int f = -1;
		
		//1、随机生成数值/放入arr[]数组中
		Random r = new Random();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = r.nextInt(100);
		}
		//2、输出数组的数
		System.out.println("生成的随机数列是：");
		for (int j = 0; j < arr.length; j++) {
			System.out.print(arr[j] + "、");
		}
		System.out.println();
		//3、通过键盘输入，输入自己所需要查的值
		System.out.print("请输入所需要查询的数值：");
		Scanner s = new Scanner(System.in);
		int x = s.nextInt();
		//4、通过数组遍历，比较输入值和数组值
		for (int i = 0; i < arr.length; i++) {
			if (x == arr[i]) {
				f = i;
				break;
			}
		}
		//5、输出查询结果
		if (f < 0) {
			System.out.println("没有找到相同的数值");
		}else{
			System.out.println("相同的数值为：" + x + "，在数组的位置是：" + (f+1) );
		}
		
	}

}
