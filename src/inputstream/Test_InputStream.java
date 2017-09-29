package inputstream;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author lijianfu
 *
 *InputStream ： 是所有字节输入流的超类，一般使用它的子类：FileInputStream等，
 *它能输出字节流；
 */
public class Test_InputStream {

	
	/**
	 * 获取字节流
	 * @param url
	 * @return
	 */
	private String getStream(String url){
		//获取字节流
		InputStream in = null;
		String result = " ";
		try {
			in = new URL(url).openStream();
			int temp;
			while((temp = in.read()) != -1){
				result += (char)temp;
			}
		}catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		//输出字节流
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String URL = "http://www.baidu.com";
		Test_InputStream test = new Test_InputStream();
		System.out.println(test.getStream(URL));
	}

}
