package thinkInJava;

import java.util.Stack;

/**
 * @author lijianfu
 * “栈”，后进先出的容器
 */
public class HoldingStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<String> stack = new Stack<String>();
		for(String s : "you are my sunshine ！".split(" "))
			stack.push(s);
		while(!stack.empty()){
			System.out.println(stack.pop() + " ");
		}
		
		Stack<Character> sc = new Stack<Character>();
		sc.push('U');
		sc.push('n');
		sc.push('c');
		System.out.print(sc.pop());
		System.out.print(sc.pop());
		System.out.print(sc.pop());
		sc.push('e');
		sc.push('r');
		sc.push('t');
		System.out.print(sc.pop());
		System.out.print(sc.pop());
		System.out.print(sc.pop());
		sc.push('a');
		sc.push('i');
		sc.push('n');
		sc.push('t');
		System.out.print(sc.pop());
		System.out.print(sc.pop());
		System.out.print(sc.pop());
		sc.push(' ');
		System.out.print(sc.pop());
		sc.push('r');
		sc.push('u');
		System.out.print(sc.pop());
		System.out.print(sc.pop());
		sc.push('l');
		sc.push('e');
		sc.push('s');
		System.out.print(sc.pop());
		System.out.print(sc.pop());
		System.out.print(sc.pop());		
	}

}
