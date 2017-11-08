package generics;

import java.util.Arrays;
import java.util.List;

/**
 * 声明无线通配符参数时，只需要列出问号（？）
 * @author lijianfu
 * 2017年11月7日
 * 下午3:39:05
 */
public class UnboundedWildcards {

	public static void printAll(List<?> list){
		for (Object object : list) {
			System.out.println(object + " ");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> integerList = Arrays.asList(10, 12, 18);
		printAll(integerList);
		
		List<Double> doubleList = Arrays.asList(10.4, 13.5, 123.9);
		printAll(doubleList);
	}

}
