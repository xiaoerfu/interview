package algorithm.basic_math;

import java.text.DecimalFormat;

/**
 * 二维多项式求值
 * @author lijianfu
 * 2017年11月23日
 * 上午10:28:45
 */
public class MultidimensionalPolynomial {

	//m、n分别是二多项式自变量x和y的项数，数组a为二维多项式系数，x、y为指定的求值点
	private static double polynominal(double a[][], int m, int n, double x, double y){
		double result = 0.0;
		double temp;
		double tt = 1.0;
		for (int i = 0; i < m; i++) {
			temp = a[i][n-1]*tt;
			for (int j = n-2; j >= 0; j--) {
				temp = temp*y + a[i][j]*tt;
			}
			result = result + temp;
			tt *= x;
		}
		
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double result;
		double x, y;
		//保留位数
		DecimalFormat decimalFormat = new DecimalFormat("0.000E000");
		double a[][] = {{1.0,2.0,3.0,4.0,5.0},
							{6.0,7.0,8.0,9.0,10.0},
							{11.0,12.0,13.0,14.0,15.0},
							{16.0,17.0,18.0,19.0,20.0}};
		x = 0.5;
		y = -2.0;
		System.out.println("二维多项式求值：");
		
		result = polynominal(a,4,5,x,y);
		
		System.out.println("p(" + x + "," + y + ")=" + decimalFormat.format(result));
	}

}
