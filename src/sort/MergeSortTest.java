package sort;

/**
 * 合并算法
 * @author lijianfu
 * 2017年11月21日
 * 上午11:17:26
 */
public class MergeSortTest {

	static final int SIZE = 10;
	
	//完成一遍合并的函数
	static void mergeOne(int a[], int b[], int n, int len){
		int i, j, k, s, e;
		
		s= 0;
		while (s+len < n) {
			e = s+2*len -1;
			if (e >= n) {								//最后一段可能少于len结点
				e = n-1;		
			}
			//相邻有序合并
			k = s;
			i = s;
			j = s + len;
			while (i<s+len && j<= e) {					//如果两个有序表都未结束时，循环比较
				if (a[i] <= a[j]) {
					b[k++] = a[i++];
				}else{
					b[k++] = a[j++];
				}
			}
			while (i < s+len) {
				b[k++] = a[i++];
			}
			while (j <= e) {
				b[k++] = a[j++];
			}
			s = e+1;
		}
		if (s < n) {
			for (; s < n; s++) {
				b[s] = a[s];
			}
		}
	}
	
	//合并排序
	static void mergeSort(int a[], int n){
		int h, count, len, f;
		count = 0;
		len = 1;
		f = 0;
		
		int[] p = new int[n];
		while (len<n) {
			if (f == 1) {								//交替在A和P之间合并
				mergeOne(p, a, n, len);					//p合并到a
			}else{
				mergeOne(a, p, n, len);                 //a合并到p
			}
			len = len*2;
			f = 1-f;									//使f值在0-1之间切换
			
			count++;
			System.out.println("第" + count + "步排序结果:");
			for (h = 0; h < SIZE; h++) {
				System.out.print(a[h] + " ");
			}
			System.out.println();
		}
		if (f == 1) {
			for (h = 0; h < n; h++) {
				a[h] = p[h];
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[SIZE];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(100+Math.random()*(100+1));
		}
		System.out.println("排序前的数组：");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		mergeSort(arr, SIZE);
		
		System.out.println("排序后的数组：");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
