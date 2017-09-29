package sort;

public class InsertSort {

/*	直接插入排序法
	基本思想：在要排序的一组数中，假设前面(n-1) [n>=2] 个数已经是排

	好顺序的，现在要把第n个数插到前面的有序数中，使得这n个数

	也是排好顺序的。如此反复循环，直到全部排好顺序。*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};  
		int temp = 0;
		System.out.println(a.length + "位数");
		System.out.println("排序前.............");
		for(int i=1; i<a.length; i++){		//遍历有多少个数

			System.out.print(a[i] + ",");
			int j=i-1;  					
			temp=a[i]; 
			for(; j>=0&&temp<a[j]; j--){	//现在是从小到大排序
				a[j+1] = a[j];				//将大于temp的值整体后移一个单位
			}
			a[j+1] = temp;
		}
		System.out.println();
		System.out.println("排序后.............");
		for(int i=0; i<a.length; i++){
			System.out.print(a[i] + ",");
		}
	}
}
