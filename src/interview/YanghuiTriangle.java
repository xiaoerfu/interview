package interview;

/**
 * 打印出杨辉三角（要求打印出10行）
 * @author lijianfu
 * 2017年10月23日
 * 下午2:50:38
 */
public class YanghuiTriangle {

	public static void main(String[] args) {
		//定义一个二维数组
		int[][] a=new int[10][10];
		//通过循环给这个数组的每一行的第一个元素和最后一个元素为1
        for(int i=0;i<10;i++){
         a[i][0]=1;
         a[i][i]=1;
        }
        //开始循环打印输出
        for(int i=0;i<10;i++){
        	//打印空格，呈现三角形形式
        	for (int k = 0; k < 2*(10-i)-1; k++) {
				System.out.print(" ");
			}
        	//进行每行打印
        	for(int j=0;j<=i;j++){ 
				if(a[i][j]!=1)
				a[i][j]=a[i-1][j-1]+a[i-1][j];
				System.out.print(a[i][j]+"   ");
        	}
         System.out.println("");
        }
}

}
