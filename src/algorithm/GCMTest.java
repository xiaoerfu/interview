package algorithm;

/**
 * 求解最大公约数
 * @author lijianfu
 * 2017年11月30日
 * 下午3:30:43
 */
public class GCMTest {

	public static void main(String[] args) {
		
		// 欧几里得的辗转相除算法
		System.out.println("最大公约数：" + gcd(5, 6));
		
		//欧几里得的辗转相除算法的改进
		System.out.println("最大公约数：" + gcb1(5,45));
		
		//求最小公倍数=（自然数a * 自然数b）÷ a和b的最大公约数
		System.out.println("5和6的最小公倍数是：" + (5*6)/gcd(5,6));
	}
	
	/**
	 * 欧几里得的辗转相除算法求两个自然数的最大公约数
	 * @param a
	 * @param b
	 * @return
	 */
	public static int gcd(int a, int b){
		int m, n, r;
		if (a > b) {
			m = a;
			n = b;
		}else{
			m = b;
			n = a;
		}
		r = m % n;							//求余数
		while (r != 0) {					//辗转相除
			m = n;
			n = r;
			r = m % n;
		}
		return n;							//返回最大公约数
	}
	
	/**
	 * 欧几里得算法改进
	 * @param a
	 * @param b
	 * @return
	 */
	public static int gcb1(int a, int b){
		int m, n, r;
		if (a > b) {
			m = a;
			n = b;
		}else{
			m = b;
			n = a;
		}
		if (n == 0) {							//若较小数为0
			return m;							//返回另一数为最大公约数
		}
		if (m % 2 == 0 && n % 2 == 0) {			//m和n都是偶数
			return 2*gcb1(m/2, n/2);			//递归调用gcb1函数，将m，n都除以2
		}
		if (m % 2 == 0) {						//m为偶数
			return gcb1(m/2, n);				//递归调用gcb1函数，将m除以2
		}
		if (n % 2 == 0) {						//n位偶数
			return gcb1(m, n/2);				//递归调用gcb1函数，将n除以2
		}
		return gcb1((m+n)/2, (m-n)/2);			//m、n都是奇数，递归调用gcb1
	}

}
