package sort;

public class BubbleSort {

//	冒泡排序法
//	基本思想：基本思想：在要排序的一组数中，对当前还未排好序的范围内的全部数，自上而下对相邻的两个数依次进行比较和调整，
//	让较大的数往下沉，较小的往上冒。即：每当两相邻的数比较后发现它们的排序与排序要求相反时，就将它们互换。
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {1,54,6,3,78,34,12,45,56,100};
		int temp = 0;
		for(int i=0; i<a.length-1; i++){
			for(int j=0; j<a.length-1-i; j++){
				if (a[j]>a[j+1]) {
					temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;	
				}
			}
		}
		for(int i=0; i<a.length; i++){
			System.out.print(a[i] + ",");
		}
//		System.out.println();
//		int b[] = {3,2,5,1,6,4,2,6};
//		int tem = 0;
//		for(int i=0; i<b.length-1; i++){
//			for(int j=0; j<b.length-1-i; j++){
//				if(b[j] > b[j+1]){
//					tem = b[j];
//					b[j] = b[j+1];
//					b[j+1] = tem;
//				}
//			}
//		}
//		for(int i=0; i<b.length-1; i++){
//			System.out.print(b[i] + ",");
//		}
	}

}
