package interview;

import java.util.Scanner;

/**
 * 输入三个整数x，y，z，请把这三个数由小到大输出。
 * @author lijianfu
 *
 */
public class SortTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Input fnc = new Input();
		System.out.println("请输入第一个数：");
		int x = fnc.Input();
		System.out.println("请输入第二个数：");
		int y = fnc.Input();
		System.out.println("请输入第三个数：");
		int z = fnc.Input();
		int a[] = {x, y, z};
		int temp = 0;
		for (int i = 0; i < a.length-1; i++) {
			for (int j = 0; j < a.length-1-i; j++) {
				if(a[j] > a[j+1]){
					temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
		System.out.println("三个数从小到大排序如下：");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
}
class Input{
	public int Input(){
		int value = 0;
		Scanner s = new Scanner(System.in);
		value = s.nextInt();
		return value;
	}
}
