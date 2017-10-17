package interview;

import java.util.Scanner;

/**
 * @author lijianfu
 *
 */
public class Recursion5 {

	public static void main(String[] args) {
		//	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			Scanner sc = new Scanner(System.in);
					
			System.out.println("Enter your value:");
			int num = sc.nextInt();
			System.out.println("your value is:" + num);
			doubleNum(num);
	}

	private static void doubleNum(int str) {
		// TODO Auto-generated method stub
		System.out.println(str);
		if (str <= 5000) {
			doubleNum(str*2);
			System.out.println(str);
		}
	}

}
