package test;

import java.util.Arrays;

public class SwapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[]{(int)(Math.random()*10),
				(int)(Math.random()*10),
				(int)(Math.random()*10),
				(int)(Math.random()*10),
				(int)(Math.random()*10),
				(int)(Math.random()*10),
				(int)(Math.random()*10)};
		System.out.print(a);
		System.out.println();
		System.out.print(Arrays.toString(a));
		swap(a);
		System.out.println();
		System.out.print(Arrays.toString(a));
	}

	private static void swap(int[] a) {
		// TODO Auto-generated method stub
		int len = a.length;
		for (int i = 0; i < len/2; i++) {
			int temp = a[i];
			a[i] = a[len-1-i];
			a[len-1-i] = temp;
		}
	}

}
