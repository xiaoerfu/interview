package generics;

/**
 * 泛型方法
 * @author lijianfu
 * 2017年11月7日
 * 下午1:33:06
 */
public class Methods {

	//定义一个泛型方法
	public static <E> void printArray(E[] inputArray){
		//显示元素
		for (E e : inputArray) {
			System.out.printf("%s ", e);
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] intArray = {1, 2, 3, 4, 5, 6};
		Double[] doubleArray = {1.1, 1.2, 1.3, 1.4, 1.5, 1.6};
		Character[] charArray = {'I', 'H', 'A', 'T', 'E', 'A', 'J', 'B'};;
		
		System.out.println("Array integerArray contains:");
		printArray(intArray);
		
		System.out.println("Array doubleArray contains:");
		printArray(doubleArray);
		
		System.out.println("Array charArray contains:");
		printArray(charArray);
	}

}
