package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * 参数化类型
 * 泛型类可以具有参数化类型，其中类型参数可以用参数化类型代替
 * @author lijianfu
 * 2017年11月7日
 * 下午1:55:41
 */
public class ParameterizedTypesTest {

	public static void main(String[] args) {
		Box4<Integer, List<String>> box = new Box4<Integer, List<String>>();
		List<String> messages = new ArrayList<String>();
		messages.add("My");
		messages.add("Love");
		messages.add("is");
		messages.add("you");
		
		box.add(Integer.valueOf(104), messages);
		System.out.printf("Integer value is: %d\n", box.getFirst());
		System.out.printf("String value is: %s\n", box.getSecond());
		
	}

}

class Box4<T, S>{
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
