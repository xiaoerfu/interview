package sort;

public class SelectSort {

	/*选择排序
	 * 基本思想：在要排序的一组数中，选出最小的一个数与第一个位置的数交换；

	然后在剩下的数当中再找最小的与第二个位置的数交换，如此循环到倒数第二个数和最后一个数比较为止*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]={1,54,6,3,78,34,12,45,56,100}; 
		int position = 0;
		for(int i=0; i<a.length; i++){
			int j = i+1;
			position = i;
			int temp = a[i];
			
			for(;j<a.length;j++){
				if (temp>a[j]) {
					temp = a[j];			//交换值
					position = j;			//坐标交换
					
				}
			}
			a[position] = a[i];				
			a[i] = temp;
		}
		for(int i=0; i<a.length; i++){
			System.out.print(a[i] + ",");
		}
		
	}

}
