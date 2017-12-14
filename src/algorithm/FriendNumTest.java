package algorithm;

/**
 * 计算亲密数算法
 * @author lijianfu
 * 2017年11月30日
 * 上午11:01:30
 */
public class FriendNumTest {

	static int ga[] = new int[100];				//初始化数组
	static int gb[] = new int[100];
	
	static int friendNum(int a){
		int b1, b2, count;
		for (int i = 0; i < 100; i++) {				//清空数组
			ga[i] = gb[i] = 0;						
		}
		count = 0;									//数组下标
		b1 = 0;										//累加和
		for (int i = 1; i < a; i++) {
			if (a%i == 0) {							//a能被i整除
				ga[count++] = i;					//保存因子到数组，方便输出
				b1 = b1 + i;						//累加因子之和
			}
		}
		
		//第二个数
		count = 0;									//数组下标
		b2 = 0;										//累加和
		for (int i = 1; i < b1; i++) {		//将数a因子之和在进行因子分解
			if (b1 % i == 0) {						//a能被i整除
				gb[count++] = i;					//保存因子到数组，方便输出
				b2 = b2 + i;						//累加因子之和
			}
		}
		
		if (b2 == a && a < b1) {
			return b1;
		}else{
			return 0;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int b, fanwei, count;
		fanwei = 5000;									//初始化范围
		System.out.printf("列举1~%d之间的所有亲密数对！\n", fanwei);
		for (int i = 0; i < fanwei; i++) {
			b = friendNum(i);
			if (b != 0) {
				System.out.printf("\n%d~~%d是亲密数，示例如下：", i,b);	//输出亲密数
				System.out.printf("\n%d的各个因子之和为：1", i);
				count = 1;
				while (ga[count] > 0) {
					System.out.printf("+%d", ga[count]);
					count++;
				}
				System.out.printf("=%d\n", b);
				System.out.printf("%d的各个因子之和为：1", b);
				count = 1;											//输出另一个数的因子
				while (gb[count] > 0) {
					System.out.printf("+%d", gb[count]);
					count++;
				}
				System.out.printf("=%d\n", i);
			}
		}
	}

}
