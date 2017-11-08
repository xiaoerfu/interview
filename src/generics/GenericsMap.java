package generics;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Map接口提供了泛型的支持
 * Map<T> map = new HashMap<T>();
 * @author lijianfu
 * 2017年11月7日
 * 下午3:05:52
 */
public class GenericsMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		map.put(1, 10);
		map.put(2, 11);
		
		Map<String, String> stringMap = new HashMap<String, String>();
		
		stringMap.put("1", "This is my String value of 1");

        stringMap.put("k1", "Key-One-Value");
        stringMap.put("k2", "Key-Two-Value");
        stringMap.put("k2", "Key-Two-Value");
        stringMap.put("jdk", "JDK 1.8");
        stringMap.put("py", "Python 3.5.6");
        

        System.out.printf("Integer Value :%d\n", map.get(1));
        System.out.printf("String Value :%s\n", stringMap.get("1"));
        
        // iterate keys.
        Iterator<Integer> integerIterator = map.keySet().iterator();

        while (integerIterator.hasNext()) {
            System.out.printf("Integer Value :%d\n", integerIterator.next());
        }

        // iterate values.
        Iterator<String> stringIterator = stringMap.values().iterator();

        while (stringIterator.hasNext()) {
            System.out.printf("String Value :%s\n", stringIterator.next());
        }
		
	}

}
