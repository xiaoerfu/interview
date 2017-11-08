package interview;

import java.util.Scanner;

/**
 * 利用三目运算符区别分数等级
 * @author lijianfu
 *
 */
public class TernaryOperatorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("请输入一个分数：");
		int grade = s.nextInt();
		char level = grade >= 90 ? 'A' : grade >= 60 ? 'B'
				:'C';
		System.out.println(level);
	}

}
