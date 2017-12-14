package algorithm;

/**
 * 求解水仙花数
 * @author lijianfu
 * 2017年11月30日
 * 下午3:27:32
 */
public class NarcissusNum {

	static void NarcissusNum(int n){
		long i, start, end, temp, num, sum;
		int j;

		start = (long)Math.pow(10,n-1);						//起始数据 Math.pow(底数,几次方)
		end = (long)Math.pow(10,n)-1;						//终止数据

		for (i = start; i <= end; i++) {					//逐个判断
			temp = 0;
			num = i;
			sum = 0;
			for (j = 0; j < n; j++) {						//分解各位
				temp = num%10;
				sum = sum + (long)Math.pow(temp, n);		//n次幂累加
				long a = num - temp;
				num = a/10;
			}
			if (sum == i) {
				System.out.println(i);						//输出水仙花数
			}
		}
	}
	public static void main(String[] args) {
		int n;
		
		n = 3;
		System.out.printf("列举%d位的水仙花数：\n", n);
		NarcissusNum(n);
		System.out.println();

		n = 4;
		System.out.printf("列举%d位的水仙花数：\n", n);
		NarcissusNum(n);
		System.out.println();

		n = 20;
		System.out.printf("列举%d位的水仙花数：\n", n);
		NarcissusNum(n);
		System.out.println();
		
		
	}

}
