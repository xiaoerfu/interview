package algorithm.thingking;

import java.util.Scanner;

/**
 * 通过蒙特卡罗算法求解圆周率π
 * @author lijianfu
 * 2017年11月20日
 * 下午2:23:15
 */
public class ProbabilisticAlgorithmTest {

	static double MontePI(int n){
		double PI;
		double x, y;
		int sum = 0;
		for (int i = 0; i < n; i++) {
			x = Math.random();
			y = Math.random();
			if ((x*x + y*y) <= 1) {		//若在阴影区内
				sum++;					//计数
			}
		}
		PI = 4.0*sum/n;					//计算PI
		return PI;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n;
		double PI;
		System.out.println("蒙特卡罗算法计算PI：");
		Scanner input = new Scanner(System.in);
		System.out.println("输入点的数量：");
		n = input.nextInt();
		PI = MontePI(n);
		System.out.println("PI = " + PI);
	}

}
