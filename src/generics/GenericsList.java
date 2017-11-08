package generics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * List泛型支持
 * List<T> list = new ArrayList<T>();
 * @author lijianfu
 * 2017年11月7日
 * 下午2:57:45
 */
public class GenericsList {

	public static void main(String[] args) {
		
		List<Integer> integerList = new ArrayList<Integer>();
		
		integerList.add(Integer.valueOf(101));
		integerList.add(Integer.valueOf(102));
		
		List<String> stringList = new ArrayList<String>();
		stringList.add("java");
		stringList.add("Python");
		stringList.add("javaScript");
		
		System.out.printf("Integer Value is: %d\n", integerList.get(0));
		System.out.printf("String Value is: %s\n", stringList.get(0));
		
		for (Integer data : integerList) {
			System.out.printf("Integer Value is: %d\n", data);
		}
		
		//通过迭代进行数据的遍历
		Iterator<String> stringIterator = stringList.iterator();
		while (stringIterator.hasNext()) {
			System.out.printf("String Value is: %s\n", stringIterator.next());
		}
	}

}
