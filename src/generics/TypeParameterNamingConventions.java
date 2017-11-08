package generics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
    E - 元素，主要由Java集合(Collections)框架使用。
    K - 键，主要用于表示映射中的键的参数类型。
    V - 值，主要用于表示映射中的值的参数类型。
    N - 数字，主要用于表示数字。
    T - 类型，主要用于表示第一类通用型参数。
    S - 类型，主要用于表示第二类通用类型参数。
    U - 类型，主要用于表示第三类通用类型参数。
    V - 类型，主要用于表示第四个通用类型参数。
 * @author lijianfu
 * 2017年11月7日
 * 上午11:45:17
 */
public class TypeParameterNamingConventions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyBox<Integer, String> box = new MyBox<Integer, String>();
        box.add(Integer.valueOf(199), "Hello World");
        System.out.printf("Integer Value :%d\n", box.getFirst());
        System.out.printf("String Value :%s\n", box.getSecond());

        Pair<String, Integer> pair = new Pair<String, Integer>();
        pair.addKeyValue("1", Integer.valueOf(100));
        System.out.printf("(Pair)Integer Value :%d\n", pair.getValue("1"));

        @SuppressWarnings("rawtypes")
		CustomList<MyBox> list = new CustomList<MyBox>();
        list.addItem(box);
        System.out.printf("(CustomList)Integer Value :%d\n", list.getItem(0)
                .getFirst());
	}

}

/**
 * 
 * @author lijianfu
 * 2017年11月7日
 * 上午11:44:52
 * @param <T>
 * @param <S>
 */
class MyBox<T, S>{
	private T t;
	private S s;
	
	public void add(T t, S s){
		this.t = t;
		this.s = s;
	}
	
	public T getFirst(){
		return t;
	}
	
	public S getSecond(){
		return s;
	}
}

/**
 * 
 * @author lijianfu
 * 2017年11月7日
 * 上午11:44:59
 * @param <K>
 * @param <V>
 */
class Pair<K, V>{
	private Map<K, V> map = new HashMap<K, V>();
	
	public void addKeyValue(K key, V value){
		map.put(key, value);
	}
	
	public V getValue(K key){
		return map.get(key);
	}
}

/**
 * 一般使用于集合类
 * @author lijianfu
 * 2017年11月7日
 * 上午11:47:50
 * @param <E>
 */
class CustomList<E>{
	private List<E> list = new ArrayList<E>();
	
	public void addItem(E value){
		list.add(value);
	}
	
	public E getItem(int index){
		return list.get(index);
	}
}
