package inputstream;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * @author lijianfu
 * InputStreamReader ： 是字节流与字符流之间的桥梁，能将字节流输出为字符流，
 * 并且能为字节流指定字符集，可输出一个个的字符；
 */
public class Test_InputStreamReader {

	/**
	 * 得到字符流之前先得到字节流
	 * @param url
	 * @return
	 */
	private String getStream(String url){
		try {
			//获取字节流
			InputStream in = new URL(url).openStream();
			//将字节流转化为字符流,并指定字符集
			InputStreamReader isr = new InputStreamReader(in, "UTF-8");
			String result = " ";
			int temp;
			while((temp = isr.read()) != -1){
				result += (char)temp;
			}
			return result;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String URL = "http://www.baidu.com";
		Test_InputStreamReader test = new Test_InputStreamReader();
		System.out.print(test.getStream(URL));
	}

}
