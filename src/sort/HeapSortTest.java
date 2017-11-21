package sort;

/**
 * 堆排序，利用堆结构和二叉树的性质完成数据的排序
 * @author lijianfu
 * 2017年11月21日
 * 上午10:03:22
 */
public class HeapSortTest {

	static final int SIZE = 10;
	
	static void heapSort(int a[], int n){
		int i,j,h,k;
		int t;
		
		//比较结点，交换数据
		for (i = n/2-1; i >= 0; i--) {					//将a[0, n-1]建成大根堆
			while (2*i+1 < n) {							//第i个结点有右子数
				j = 2*i + 1;
				if ((j+1) < n) {
					if (a[j] < a[j+1]) {				//右左子树小于左子树，则需要比较右字树
						j++;							//序号增加1，指向右字树
					}
				}
				if (a[i] < a[j]) {						//比较i和j为序号的数据
					t = a[i];							//交换数据
					a[i] = a[j];
					a[j] = t;
					i = j;								//堆被破坏，需要重新调整
				}else{									//
					break;
				}
			}
		}
		
		//输出构成的堆
		System.out.println("源数据构成的堆：");
		for (h = 0; h < n; h++) {
			System.out.print(a[h] + " ");
		}
		System.out.println();
		for (i = n-1; i > 0; i--) {
			t = a[0];
			a[0] = a[i];
			a[i] = t;
			k = 0;
			while (2*k+1 < i) {							//第i个结点有右子数
				j = 2*k + 1;
				if ((j+1) < i) {
					if (a[j] < a[j+1]) {				//右左子树小于左子树，则需要比较右字树
						j++;							//序号增加1，指向右字树
					}
				}
				if (a[k] < a[j]) {						//比较i和j为序号的数据
					t = a[k];							//交换数据
					a[k] = a[j];
					a[j] = t;
					k = j;								//堆被破坏，需要重新调整
				}else{									//
					break;
				}
			}
			
			System.out.print("第" + (n-i) + "步排序结果："); //输出每一步的排序结果
			for (h = 0; h < n; h++) {
				System.out.print(" " + a[h]);
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[SIZE];
		long startTime = System.currentTimeMillis();
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(100 + Math.random()*(100 + 1));
		}
		
		System.out.println("排序前的数组：");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
		heapSort(arr, SIZE);
		
		System.out.println("排序后的数组：");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		
		System.out.println();
		long endTime = System.currentTimeMillis();
		System.out.println("总共经过：" + (endTime-startTime) + "秒！");
	}

}
