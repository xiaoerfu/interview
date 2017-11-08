package interview;

/**
 * 一个整数，加上100后是一个完全平方数，再加上168又是一个完全平方数，
 * 求这个数是什么？
 * @author lijianfu
 *
 */
public class SqrtTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 100000000; i++) {
			long a = (long) Math.sqrt(i+100);
			long b = (long) Math.sqrt(i+168);
			if (a*a == (i+100) && b*b == (i+168)){
				System.out.println("这个数为：" + i);
			}
		}
	}

}
