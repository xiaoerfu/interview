package algorithm.basic_math;

import java.util.Scanner;

/**
 * 利用割圆术求PI
 * @author lijianfu
 * 2017年11月24日
 * 下午2:53:49
 */
public class SeekPI {

	static void cyclotomic(int n){
		int i, s;
		double k, len;
		i = 0;
		k = 3.0;						//初值
		len = 1.0;						//边长初值
		s = 6;							//初始内接正六边行
		
		while (i <= n) {
			System.out.printf("第%2d次切割，为正%5d边形，PI=%.24f\n",i,s,k*Math.sqrt(len));
			s*=2;
			len = 2-Math.sqrt(4-len);		//内接多边形的边长
			i++;
			k*=2.0;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n;
		System.out.println("请输入切割的次数：");
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		cyclotomic(n);
	}

}
