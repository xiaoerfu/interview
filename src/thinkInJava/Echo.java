package thinkInJava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Echo {

	 static String s1 = "你好";
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String s2 = "java";
//		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//		String s ;
//		while ((s = bf.readLine()) != null && s.length() != 0) {
//			System.out.println(s);
//			PrintWriter out = new PrintWriter(System.out, true);
//			out.println(s);
//		}
		System.out.println(s1);
		System.out.println(s2);
	}
}
