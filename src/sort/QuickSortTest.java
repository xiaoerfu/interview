package sort;

/**
 * 快速排序法，采用分治算法思想
 * @author lijianfu
 * 2017年11月21日
 * 上午9:07:49
 */
public class QuickSortTest {

	static final int SIZE = 10;
	static void quickSort(int arr[], int left, int right){
		int f,t;
		int rtemp,ltemp;
		
		ltemp = left;
		rtemp = right;
		f = arr[(left+right)/2];
		while (ltemp < rtemp) {
			while (arr[ltemp] < f) {
				++ltemp;
			}
			while (arr[rtemp] > f) {
				--rtemp;
			}
			if (ltemp <= rtemp) {
				t = arr[ltemp];
				arr[ltemp] = arr[rtemp];
				arr[rtemp] = t;
				--rtemp;
				++ltemp;
			}
		}
		if (ltemp == rtemp) {
			ltemp++;
		}
		if (left < rtemp) {
			quickSort(arr, left, ltemp-1);							//递归调用
		}
		if (ltemp < right) {
			quickSort(arr, rtemp+1, right);							//递归调用
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[SIZE];
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(100 + Math.random()*(100+1));			//初始化数组
		}
		System.out.println("排序前数组：");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		quickSort(arr, 0, SIZE-1);									//排序操作
		
		System.out.println("排序后的数组：");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");							//输出排序后的数组
		}
		System.out.println();
		long endTime = System.currentTimeMillis();
		System.out.println("总共经过" + (endTime - startTime) + "秒！");
	}

}
