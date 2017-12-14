package algorithm.basic_math;

import java.text.DecimalFormat;

/**
 * 多项式乘法乘积多项式的最高次数为m+n-2,有多少项为：k=m+n-1
 * @author lijianfu
 * 2017年11月23日
 * 上午11:13:39
 */
public class MultiplicationPolynomial {

	/**
	 * 输入参数A[]和m分别为多项式A(x)的系数矩阵和项数
	 * 输入参数B[]和n分别为多项式B(x)的系数矩阵和项数
	 * 输入参数R[]和k分别为多项式R(x)的系数矩阵和项数
	 */
	private static void polynomialMul(double A[], int m, double B[], int n, double R[], int k){
		for (int i = 0; i < k; i++) {
			R[i] = 0.0;
		}
		for (int j = 0; j < m; j++) {
			for (int k1 = 0; k1 < n; k1++) {
				R[j+k1] = R[j+k1] + A[j]*B[k1];
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double A[] = {-4.0,5.0,2.0,-1.0,3.0,2.0};
		double B[] = {-3.0,-2.0,2.0,3.0};
		double R[] = new double[9];
		DecimalFormat decimalFormat = new DecimalFormat("0.00");
		
		polynomialMul(A, 6, B, 4, R, 9);
		
		System.out.println("多项式A(x)和B(x)乘积的各项系数如下：");
		
		for (int i = 0; i < R.length; i++) {
			System.out.println("R(" + i + ")=" + decimalFormat.format(R[i]));
		}
	}

}
