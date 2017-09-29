package thinkInJava;

import java.util.LinkedList;
import java.util.ListIterator;

public class HoldingTest14 {
	
	static void addMiddle(LinkedList<Integer>l, Integer[] ia){
		for(Integer i : ia){
			ListIterator<Integer> it = 
					l.listIterator((l.size())/2);	//使用ListIterator插入
			it.add(i);								//添加数	
			System.out.println(l);					//打印输出
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> li = new LinkedList<Integer>();		//创建一个空的LinkedList<Integer>
		Integer[] x = {1,2,3,4,5,6,7,8};
		HoldingTest14.addMiddle(li, x);
	}

}
