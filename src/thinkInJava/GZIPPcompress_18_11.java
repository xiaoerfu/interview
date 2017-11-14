package thinkInJava;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class GZIPPcompress_18_11 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(
				new FileReader("C:/Users/lijianfu/Desktop/综合管理后台系统测试.doc"));
		BufferedOutputStream out = new BufferedOutputStream(new GZIPOutputStream(
				new FileOutputStream("C:/Users/lijianfu/Desktop/test.gz")));
		System.out.println("Write file");
		int c;
		while((c=in.read()) != -1){
			System.out.print(c + "、");
			out.write(c);
		}
		in.close();
		out.close();
		
		System.out.println();
		System.out.println("Reading file");
		BufferedReader in1 = new BufferedReader(new InputStreamReader(
				new GZIPInputStream(new FileInputStream("C:/Users/lijianfu/Desktop/test.gz"))));
		String s;
		while ((s=in1.readLine()) != null) {
			System.out.println(s);
		}
	}

}
