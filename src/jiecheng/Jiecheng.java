package jiecheng;

public class Jiecheng {
	
//	public static void main(String[] args){
//		System.out.println(jiecheng(20));
//	}
//	
//	/**
//	 * @param m
//	 * @return
//	 */
//	public static int jiecheng(int m){
//		if(m == 1){
//			return 1;
//		}else{
//		int result = 1;
//		for (int i = 0; i <= m; i++) {
//			result*=i;
//		}
//		return result + jiecheng(m-1);
//		}
//		
//	} 
	 public static void main(String args[]){
		 System.out.println("求和:"+sum(20));

	 }

	 public static long sum(int m) //求n个数的和
	 {
	 long sum=0;
	 for(int i=1;i<=m;i++)
	 {
	 sum=sum+jiecheng(i);
	 }
	 return sum;
	 } 
	 
	 public static int jiecheng(int n) //求n!函数
	 {
	 int result=1;
	 for(int i=n;i>0;i--)
	 {
	 result=result*i;
	 }
	 return result;
	 }

}
