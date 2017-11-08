package interview;

/**
 * 求2/1,3/2,5/3,8/5,....../求出这个数列前20项的和
 * @author lijianfu
 * 2017年10月19日
 * 下午1:46:58
 */
public class SeriesTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 2, y = 1, t;
		double sum = 0;
		for (int i = 1; i <= 20; i++) {
			sum = sum + (double)x/y;
			t = y;
			y = x;
			x = y + t;
		}
		System.out.println("前20项之和为：" + sum);
	}

}
