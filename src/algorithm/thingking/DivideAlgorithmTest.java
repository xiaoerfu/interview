package algorithm.thingking;

import java.util.Scanner;

/**
 * 利用分治算法求解假币
 * @author lijianfu
 * 2017年11月20日
 * 下午1:54:54
 */
public class DivideAlgorithmTest {

	static final int MAXNUM = 10;
	static int FalseCoin(int coin[], int low, int high){
		int i, sum1, sum2, sum3;
		int result = 0;
		sum1 = sum2 = sum3 = 0;
		if (low+1 == high) {
			if (coin[low] < coin[high]) {
				result = low + 1;
				return result;
			}else{
				result = high + 1;
				return result;
			}
		}
		if ((high-low+1) % 2 == 0) {						//n 是偶数
			for (i = low; i <= low+(high-low)/2; i++) {
				sum1 = sum1 + coin[i];						//前半段和
			}for (i = low+(high-low)/2+1; i < high; i++) {
				sum2 = sum2 + coin[i];						//后半段和
			}
			if (sum1 > sum2) {
				result = FalseCoin(coin, low+(high-low)/2+1, high);
			}else if (sum1 < sum2) {
				result = FalseCoin(coin, low, low+(high-low)/2);
				return result;
			}else{}
		}else{
			for (i = low; i <= low+(high-low)/2-i; i++) {
				sum1 = sum1 + coin[i];						//前半段和
			}for (i = low+(high-low)/2+1; i < high; i++) {
				sum2 = sum2 + coin[i];						//后半段和
			}
			sum3 = sum2 + coin[low + (high-low)/2];
			if (sum1 > sum2) {
				result = FalseCoin(coin, low+(high-low)/2+1, high);
			}else if (sum1 < sum2) {
				result = FalseCoin(coin, low, low+(high-low)/2);
				return result;
			}else{}if (sum1 + sum3 == sum2 + sum3) {
				result = low + (high-low)/2+1;
				return result;
			}
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] coin = new int[MAXNUM];
		int n;
		int location;
		System.out.println("分治求算法之求假币问题：");
		System.out.print("请输入银币总个数：");
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		System.out.println("请输入银币真假：");
		for (int i = 0; i < n; i++) {
			coin[i] = input.nextInt();
		}
		location = FalseCoin(coin, 0, n-1);
		System.out.println("在上述" + MAXNUM + "个银币中，第" + location + "个银币是假的！");
	}

}
