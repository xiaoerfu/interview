package interview;

public class Recursion6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("第八个屌丝程序员的年龄是：" + calAge(8));
	}

	private static int calAge(int i) {
		// TODO Auto-generated method stub
		if (1 == i) {
			return 10;
		}
		return calAge(i-1) + 2;
	}

}
