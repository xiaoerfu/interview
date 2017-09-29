package thinkInJava;

import java.nio.CharBuffer;
import java.util.Scanner;

public class Interface16 extends RandomChars implements Readable{
	private int count;
	public Interface16(int count){
		this.count = count;
	}
	
	public int read(CharBuffer cb){
		if(count-- == 0){
			return -1;
		}
		String result = Character.toString(next()) + " ";
		cb.append(result);
		return result.length() ;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(new Interface16(5));
		while(s.hasNext()){
			System.out.print(s.next() + " ");
		}
	}

}
