package thinkInJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 适配器方法惯用法
 * 产生一个Iterable对象的方法
 * @author lijianfu
 *
 */

class ReversibleArrayList<T> extends ArrayList<T>{

	public ReversibleArrayList(Collection<T> asList) {
		// TODO Auto-generated constructor stub
		super(asList);
	}
	public Iterable<T> reversed(){
		return new Iterable<T>(){

			public Iterator<T> iterator() {
				// TODO Auto-generated method stub
				return new Iterator<T>(){
					int current = size() -1;
					public boolean hasNext(){
						return current > -1;
					}
					public T next(){return get(current--);}
					public void remove(){
						throw new UnsupportedOperationException();
					}
				};
			}
			
		};
	}
	
}
public class ForeachTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Collection<String> cs = new LinkedList<String>();
//		Collections.addAll(cs, 
//				"Just do it".split(" "));
//		for (String string : cs) {
//			System.out.println("'" + string + "'");
//		}
		ReversibleArrayList<String> ral =
				new ReversibleArrayList<String>(
						Arrays.asList("to be or not to be".split(" ")));
		for (String string : ral) {
			System.out.print(string + " ");
		}
		System.out.println();
		for (String string : ral.reversed()) {
			System.out.print(string + " ");
		}
	}

}
