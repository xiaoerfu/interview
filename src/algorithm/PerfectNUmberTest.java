package algorithm;

/**
 * 求解完全数
 * @author lijianfu
 * 2017年11月28日
 * 上午9:54:13
 */
public class PerfectNUmberTest {
	
	static void perfectNum(long fanwei){			//计算完全数算法
		long[] p = new long[300];					//保存分解的因子
		long sum, num;
		int count;
		
		for (int i = 1; i < fanwei; i++) {				//循环处理每一个数
			count = 0;
			num = i;
			sum = num;
			for (int j = 1; j < num; j++) {				//循环处理每一个数
				if (num % j == 0) {
					p[count++] = j;						//保存因子，计数器count增加1
					sum = sum -j;						//减去一个因子
				}
			}
			if (sum == 0) {
				System.out.println(num + "是一个完全数");
				System.out.printf("%d=%d",num,p[0]);	//输出完数
				for (int k = 1; k < count; k++) {		//输出因子
					System.out.printf("+%d",p[k]);
				}
				System.out.println();
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long fanwei;
		fanwei = 10000;									//初始化范围
		System.out.printf("查找%d之内的完全数：\n", fanwei);
		perfectNum(fanwei);
	}

}
