package interview;

import java.util.Scanner;

/**
 * 求a+aa+aaa+aaaa......a的值，其中a为一个数，几个数相加由键盘控制
 * @author lijianfu
 *
 */
public class AddFreedomTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long a,b = 0, sum = 0;
		Scanner s = new Scanner(System.in);
		System.out.println("请输入数字a的值:");
		a = s.nextInt();
		System.out.println("输入相加的项：");
		int n = s.nextInt();
		 for (int i = 0; i < n; i++)  
	        {  
	            b = b * 10 + a;  //每次生成的新数
	            System.out.println(b);  
	            sum = sum + b;  
	        }  
		System.out.println(sum);
	}

}
