package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class UrlTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			long begintime = System.currentTimeMillis();
			Scanner s = new Scanner(System.in);
			String message = " ";
			while(s.hasNext()){
				message = s.next();

				URL url = new URL("http://www.tuling123.com/openapi/api?key=9ef00b2b8b81431aa2c7b7c7400d3eb2&info=" + message);
				HttpURLConnection urlcon = (HttpURLConnection)url.openConnection();
				urlcon.connect();	//获取连接
				InputStream is = urlcon.getInputStream();
				BufferedReader buffer = new BufferedReader(new InputStreamReader(is));
				//StringBuffer bs = new StringBuffer();
				StringBuilder bs = new StringBuilder();
				String l = null;
				while((l=buffer.readLine()) != null){
					bs.append(l).append("\n");
				}
				System.out.println(bs.toString());
				System.out.println(" content-encode："+urlcon.getContentEncoding());

				System.out.println(" content-length："+urlcon.getContentLength());

				System.out.println(" content-type："+urlcon.getContentType());

				System.out.println(" date："+urlcon.getDate());


				System.out.println("总共执行时间为："+(System.currentTimeMillis()-begintime)+"毫秒");
				
				//请求结束后关闭
				is.close();
			}
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}

}
