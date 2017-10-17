package thinkInJava;

import java.util.Random;

public class RandomChars {
	public static Random rand = new Random();
	public char next(){
		return (char)rand.nextInt(128);
	}
	public static void main(String[] args){
		RandomChars.main(args);
	}
}
