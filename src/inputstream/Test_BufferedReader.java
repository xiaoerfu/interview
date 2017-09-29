package inputstream;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import org.junit.Test;

/**
 * @author lijianfu
 *  提供通用的缓冲方式文本读取，readLine读取一个文本行， 
 *  从字符输入流中读取文本，缓冲各个字符，从而提供字符、数组和行的高效读取。
 *  速度比读取字符流更快。
 */
public class Test_BufferedReader {

	private static int b;
	private String getStream(String url){
		try {
			//得到字节流
			InputStream in = new URL(url).openStream();
			//将字节流转化为字符流，并指定字符集
			InputStreamReader isr = new InputStreamReader(in, "UTF-8");
			//将字符流以缓存的方式一行一行的输出
			BufferedReader bf = new BufferedReader(isr);
			String results = " ";
			String newLine = " ";
			while((newLine = bf.readLine()) != null){
				results += newLine + "\n";
			}
			return results;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	@Test
	public void test(){
		System.out.println(getStream("http://www.baidu.com"));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String URL = "http://www.baidu.com";
		Test_BufferedReader test = new Test_BufferedReader();
		System.out.println(test.getStream(URL));
		System.out.println(b);
	}

}
