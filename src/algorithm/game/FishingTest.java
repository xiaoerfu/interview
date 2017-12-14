package algorithm.game;

import java.util.Scanner;

public class FishingTest {

	static int fish(int fisherman){			//渔夫捕鱼算法
		int init;
		int n;
		int s;
		
		init = fisherman + 1;
		n = fisherman -1;
		s = init;
		while (n != 0) {
			s = 5*s + 1;
			n--;
		}
		return s;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num;
		int fisherman;
		
		System.out.printf("渔夫捕鱼问题求解！\n");
		System.out.printf("请先输入渔夫的个数：");
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		fisherman = input.nextInt();
		num = fish(fisherman);
		System.out.println("渔夫合作至少合伙捕了" + num + "条鱼！");
	}

}
