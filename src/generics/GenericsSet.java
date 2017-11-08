package generics;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Set接口中提供了泛型的支持
 * Set<T> set = new HashSet<T>();
 * @author lijianfu
 * 2017年11月7日
 * 下午2:58:23
 */
public class GenericsSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Integer> integerSet = new HashSet<Integer>();
		
		 integerSet.add(Integer.valueOf(110));
	        integerSet.add(Integer.valueOf(123));

	        Set<String> stringSet = new HashSet<String>();

	        //set存储的值不能重复
	        stringSet.add("Hello");
	        stringSet.add("World");
	        stringSet.add("Java");
	        stringSet.add("MySQL");

	        for (Integer data : integerSet) {
	            System.out.printf("Integer Value :%d\n", data);
	        }

	        Iterator<String> stringIterator = stringSet.iterator();

	        while (stringIterator.hasNext()) {
	            System.out.printf("String Value :%s\n", stringIterator.next());
	        }
	}

}
