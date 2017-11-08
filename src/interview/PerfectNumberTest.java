package interview;

/**
 * 一个数如果恰巧等于它的因子之和，这个数就称为完数，例如：
 * 6 = 1 + 2 + 3，从而请求出1000以内的所有完数
 * @author lijianfu
 *
 */
public class PerfectNumberTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("1-1000的完数有：");
		for (int i = 1; i < 1000; i++) {
			int sum = 0;
			for (int j = 1; j < i; j++) {
				if (i % j == 0) {
					sum = sum + j;
				}
			}
			if(sum == i){
				System.out.println(i + " ");
			}
		}
		
	}

}
