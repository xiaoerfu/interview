package thinkInJava;

import java.util.Random;

public class RandomChars {
	public static void main(String[] args){
		Random rand = new Random(47);
		for (int j = 0; j < 10; j++) {
			int i = rand.nextInt();
			System.out.print(i + " ");
		}
		
	}
}
