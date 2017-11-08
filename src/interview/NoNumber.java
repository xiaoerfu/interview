package interview;

/**
 * 有1、2、3 、4四个数字，能组成多少个互不相同的一个数字中且无重复数字的三位数
 * @author lijianfu
 *
 */
public class NoNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count = 0;
		for (int a = 1; a < 5; a++) {
			for (int b = 1; b < 5; b++) {
				for (int c = 1; c < 5; c++) {
					if(a != b && a != c && b != c){
						System.out.println(a*100 + b*10 + c);
						count++;
					}
				}
			}
		}
		System.out.println("总共有" + count + "个三位数");
	}

}
