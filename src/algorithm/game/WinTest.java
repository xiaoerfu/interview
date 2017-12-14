package algorithm.game;

import java.util.Scanner;

public class WinTest {

	static int computer, user, last;
	
	public static void win(){
		while (true) {
			System.out.printf("--------目前还有火柴%d根 -------\n",last);
			System.out.printf("用户取火柴数量：");
			Scanner input = new Scanner(System.in);
			user = input.nextInt();									//用户取火柴数量
			if (user<1 || user>4 || user>last) {					//用户取火柴规则
				System.out.printf("你违规了，你取的火柴数有问题！\n");
				continue;
			}
			last = last - user;										//剩余火柴的数量
			if (last == 0) {
				System.out.println("用户取得了最后一根火柴，因此计算机赢了！");
				break;
			}else{
				computer = 5 - user;								//计算机取火柴数量
				last = last - computer;
				System.out.printf("计算机取火柴数量：%d \n",computer);
				if (last == 0) {
					System.out.printf("计算机取得最后一根火柴，因此用户赢了");
					break;
				}
			}
		}
	}
	public static void main(String[] args) {
		
		int num;
		System.out.printf("常胜将军问题求解！\n");
		System.out.printf("请先输入火柴的总量为：");
		Scanner input = new Scanner(System.in);
		num = input.nextInt();
		System.out.printf("火柴的总量为%d:",num);
		last = num;
		win();
	}

}
