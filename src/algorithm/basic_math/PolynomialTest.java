package algorithm.basic_math;

import java.text.DecimalFormat;

/**
 * 求x=-2.0、-0.5、1.0、2.0/3.7和4.0处的值
 * 在多项式P(x)=3x^6+7x^5-3x^4+2x^3+7x^2-7x-15
 * @author lijianfu
 * 2017年11月22日
 * 上午11:07:02
 */
public class PolynomialTest {

	static double polynomial(double a[], int n, double x){
		double result;
		result = a[n-1];
		for (int i = n-2; i >= 0; i--) {
			result = result*x + a[i];			//递推算法求解
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double result;
		double a[] = {-15.0, -7.0, 7.0, 2.0, -3.0, 7.0, 3.0};
		double x[] = {-2.0, -0.5, 1.0, 2.0, 3.7, 4.0};
		
		DecimalFormat df = new DecimalFormat("0.0000000E000");
		DecimalFormat df1 = new DecimalFormat("0.00");
		
		System.out.println();
		for (int i = 0; i < x.length; i++) {
			result = polynomial(a, a.length, x[i]);
			System.out.println("x=" + df1.format(x[i]) + "时，P(x)=" 
			+ df.format(result) );
		}
	}

}
