package thinkInJava;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class BufferedInputFile {

	public static String read(String filename) throws IOException{
		//通过行读取一个输出文件
		//以GB2312的编码格式读取字节数组
		InputStreamReader isr = new InputStreamReader(new FileInputStream(filename), "GB2312");
		
		//BufferedReader 由Reader类扩展而来，提供通用的缓冲方式文本读取，
		//而且提供了很实用的readLine，读取一个文本行，
		//从字符输入流中读取文本，缓冲各个字符，从而提供字符、数组和行的高效读取。
		BufferedReader in = new BufferedReader(isr);
		String s;
		
		//使用一个StringBuider进行数据的存储
		StringBuilder sb = new StringBuilder();
		while ((s = in.readLine()) != null) {
			sb.append(s + "\n");
		}
		in.close();
		return sb.toString();
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		System.out.println(read("C:/Users/lijianfu/Desktop/hello.cpp"));
		System.out.println(read("D:/EclipseWorkspace/myTest/src/thinkInJava/BufferedInputFile.java"));
		StringReader in = new StringReader(BufferedInputFile.read("C:/Users/lijianfu/Desktop/hello.cpp"));
		int c ;
		while ((c = in.read()) != -1) {
			System.out.print((char)c);
		}
	}

}
