package interview;

import java.util.Scanner;

/**
 * 利用递归求出从键盘输入的数值
 * @author lijianfu
 * 2017年10月19日
 * 下午2:01:39
 */
public class Recursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("请输入所求的数：");
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		rec fr = new rec();
		System.out.println(a + "!=" + fr.rec(a));
	}
}

//递归求出n！的数
class rec{
	public long rec(int n){
		long value = 0;
		if(n ==1){
			value = 1;
		}else{
			value = n*rec(n-1);
		}
		return value;
	}
}
