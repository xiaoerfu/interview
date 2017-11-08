package interview;

import java.util.Scanner;

/**
 * 给一个不多于5位的正整数，要求：1、他是几位数， 2、逆序打印出
 * 各个数字
 * @author lijianfu
 * 2017年10月19日
 * 下午2:19:12
 */
public class ScannerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("请输入一个正整数:");
		long a = s.nextLong();
		String ss = Long.toString(a);
		char[] ch = ss.toCharArray();
		int j = ch.length;
		System.out.println("它是" + j + "位数");
		System.out.println("按照逆序方式打印如下：");
		for (int i = j-1; i >= 0; i--) {
			System.out.print(ch[i]);
		}
	}

}
