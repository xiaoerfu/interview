package algorithm.basic_math;

import java.util.Scanner;

/**
 * 判断闰年
 * @author lijianfu
 * 2017年11月22日
 * 上午10:17:38
 */
public class LeapYearTest {

	static int leapYear(int year){
		if ((year%400==0) || (year%100 != 0) || (year%4 == 0)) {
			return 1;
		}else{
			return 0;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("请输入所要查询的年是否是闰年：");
		Scanner input = new Scanner(System.in);
		
		do {
			int year = input.nextInt();
			if (year >= 0) {
				if (leapYear(year) == 1) {
					System.out.println(year + "是闰年！");
				}else{
					System.out.println(year + "不是闰年！");
				}
			}else{
				System.out.println("输入错误的数值，请重新运行");
				break;
			}
			
		} while (true);
		
	}

}
