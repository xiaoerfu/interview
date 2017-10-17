package interview;

import java.io.UnsupportedEncodingException;

/**
 * 编写一个截取字符串的函数，输入为一个字符串和字节数，
 * 输出为按字节截取的字符串，但要保证汉字不被截取半个，
 * 如“我ABC”，4，应该截取“我AB”，
 * 输入“我ABC汉DEF”，6，应该输出“我ABC”，而不是“我ABC+汉的半个”。
 * @author lijianfu
 *
 */
public class Arithmetic3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "我我de祖国add我的心";
		String str1 = "我ABC汉语";
		int num = 0;
		try {
			num = trimGBK(str.getBytes("GBK"),9);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(num);
		System.out.println(str.substring(0,num));
	}

	private static int trimGBK(byte[] bytes, int n) {
		// TODO Auto-generated method stub
		int num = 0;
		boolean bChineseFirstHalf = false;
		for (int i = 0; i < n; i++) {
			 if(bytes[i]<0 &&!bChineseFirstHalf){

                 bChineseFirstHalf= true;

        }else{

                 num++;

                 bChineseFirstHalf= false;                              

        }
		}
		return num;
	}

}
