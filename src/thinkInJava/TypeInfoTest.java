package thinkInJava;

import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

/**
 * 
 * @author lijianfu
 * 2017年11月2日
 * 上午11:41:36
 */

class CounterInteger{
	private static long counter;
	private final long id = counter++;
	public String toString(){
		return Long.toString(id);
	}
}

public class TypeInfoTest<T> {
	
	private Class<T> type;
	public TypeInfoTest(Class<T> type){
		this.type = type;
	}
	public List<T> create(int nElements){
		List<T> result = new ArrayList<>();
		try {
			for (int i = 0; i < nElements; i++) {
				result.add(type.newInstance());
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TypeInfoTest<CounterInteger> fs = 
				new TypeInfoTest<CounterInteger>(CounterInteger.class);
		System.out.println(fs.create(15));
	}

}
