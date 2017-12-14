package algorithm.cryptography;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 利用异或算法，从而实现对位进行加密，在一次异或将进行解密。
 * @author lijianfu
 * 2017年12月11日
 * 上午8:49:05
 */
public class XORTest {

	@SuppressWarnings("unused")
	public static char[] bitcode(char[] str, char n){		//位加密加密解密算法
		int len;
		char[] wen;
		len = str.length;
		if ((wen = new char[len+1]) == null) {
			System.out.println("申请内存失败！！");
			System.exit(1);;
		}
		for (int i = 0; i < len; i++) {
			wen[i] = (char) (str[i] ^ n);						//异或运算
		}
		wen[len] = '\n';
		return wen;
	}		
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		char ch;
		char[] srcstr = new char[100];						//保存明文字符串
		char[] miwen;
		String go;
		System.out.println("位加密解密算法演示：");
		do {
			System.out.print("\n请先输入替换加密解密算法中的密钥：");
			Scanner input = new Scanner(System.in);
			ch = input.next().charAt(0);						//密钥
			System.out.print("请输入明文字符串：");
			
			//利用BufferedReader缓存
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
			String str = bufferedReader.readLine();
			srcstr = str.toCharArray();
			
			System.out.print("输入的明文为：");
			for (int i = 0; i < srcstr.length; i++) {
				System.out.print(srcstr[i]);
			}
			miwen = bitcode(srcstr, ch);						//加密
			System.out.print("\n加密后的密文为：");
			for (int i = 0; i < srcstr.length; i++) {
				System.out.print(miwen[i]);
			}
			miwen = bitcode(miwen, ch);							//解密
			System.out.print("\n解密出的明文为：");
			for (int i = 0; i < srcstr.length; i++) {
				System.out.print(miwen[i]);
			}
			System.out.println("\n继续执行（y/n）");
			go = input.next();
			
		} while (go.equalsIgnoreCase("y"));
		System.out.println("演示结束！！");
	}

}
