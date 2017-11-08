package interview;

/**
 * 打印一个菱形
 * 思路：需要利用循环一行一行的把星号打印出来
 * @author lijianfu
 * 2017年10月19日
 * 上午11:39:18
 */
public class Ling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int H = 7;
		int W = 7;	//高度和宽必须是相等的奇数
		//打印上半部分
		for (int i = 0; i < (H+1)/2; i++) {
			for (int j = 0; j < W/2-i; j++) {
				System.out.print(" ");
			}
			for (int k = 1; k < (i+1)*2; k++) {
				System.out.print('*');
			}
			System.out.println();
		}
		//倒序打印下半部分
		for (int i = 1; i <= H/2; i++) {
			for (int j = 1; j <= i; j++) {
				//输出空格
				System.out.print(" ");
			}
			for (int k =1; k <= W-2*i; k++) {
				System.out.print('*');
			}
			System.out.println();
		}
	}

}
