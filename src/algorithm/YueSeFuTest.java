package algorithm;

import java.util.Scanner;

/**
 * 简单版约瑟夫环
 * @author lijianfu
 * 2017年11月27日
 * 下午3:07:05
 */
public class YueSeFuTest {

	static final int Num = 41;
	static final int KillMan = 3;
	
	static void Josephus(int alive){
		int[] man = new int[Num];						//未被杀的都标记为0
		int count = 1;									//杀到第几个记录值
		int i = 0;										
		int pos = -1;									//数组角标
		while (count <= Num) {
			do {
				pos = (pos+1) % Num;					//环处理
				System.out.print(pos + " ");
				if (man[pos] == 0) {
					i++;
					if (i == KillMan) {					//这个人该杀
						i = 0;
						break;
					}
				}
			} while (true);
			man[pos] = count;
			System.out.printf("第%2d个人自杀！约瑟夫环编号为%2d",pos+1,man[pos]);
			if (count % 2 == 1) {
				System.out.printf("-->");
			}
			else{
				System.out.printf("-->\n");
			}
			count++;
		}
		System.out.println();
		System.out.printf("这%d个需要存活的人初始位置应该排在以下哪一个序号：\n",alive);
		
		// 显示不该杀的位置
		alive = Num-alive;
		for (i = 0; i < man.length; i++) {
			if (man[i] > alive) {
				System.out.printf("初始编号：%d，约瑟夫环编号：%d\n",i+1, man[i]);
			}
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int alive;
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("约瑟夫环问题求解：");
		System.out.printf("希望存活的人数：");
		alive = input.nextInt();
		Josephus(alive);
	}

}
