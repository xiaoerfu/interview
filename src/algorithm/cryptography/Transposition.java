package algorithm.cryptography;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 换位加密解密算法
 * 实际就是利用一个二维数组存储数据，明文的方向就是按行存储，
 * 密文就是从列的方向进行读取，所以解密把原来的密文按照列读取出来就是明文了
 * @author lijianfu
 * 2017年12月4日
 * 下午2:52:42
 */
public class Transposition {

	@SuppressWarnings("unused")
	static char[] jiami(char[] str, int n){	//加密算法
		int i, d;
		int len;
		char[] temp, miwen, mtemp = {};
		
		len = str.length;						//字符串长度
		if ((d = len % n) != 0) {
			len = len + n -d;
		}
		if ((temp = new char[len+1]) == null) {	//申请内存
			System.out.println("申请内存失败！");
			System.exit(1);
		}
		if ((miwen = new char[len+1]) == null) {	//申请内存
			System.out.println("申请内存失败！");
			System.exit(1);
		}else {
			mtemp = miwen;
		}
		System.arraycopy(str, 0, temp, 0, str.length);
		for (i = str.length; i < len; i++) {
			temp[i] = 32;
		}
		temp[len] = '\0';
		i = 0;
		for (int k = 0; k < n; k++) {				//转换加密
			for (int j = 0; j < len/n; j++) {
				mtemp[i] = temp[k + j*n];
				System.out.println();
				System.out.println(mtemp[i]);
				i++;
			}
		}
		mtemp[i] = '\n';
		temp = null;
		
		return miwen;								//返回密文
	}
	
	@SuppressWarnings("unused")
	static char[] jiemi(char[] str, int n){	//解密算法
		int i, d;
		int len;
		char[] temp, mingwen, mtemp = {};
		
		len = str.length;						//字符串长度
		
		if ((d = len % n) != 0) {
			len = len -d;
		}
		if ((temp = new char[len+1]) == null) {	//申请内存
			System.out.println("申请内存失败！");
			System.exit(1);
		}
		if ((mingwen = new char[len+1]) == null) {	//申请内存
			System.out.println("申请内存失败！");
			System.exit(1);
		}else {
			mtemp = mingwen;
		}
		System.arraycopy(str, 0, temp, 0, str.length);
		for (i = str.length; i < len; i++) {
			temp[i] = 32;
		}
		temp[len] = '\0';
		i = 0;
		for (int k = 0; k < n; k++) {				//恢复出明文
			for (int j = 0; j < len/n; j++) {
				mtemp[i] = temp[k + j *n];
				i++;
			}
		}
		
		while (mtemp[--i] == 32);
		i++;
		mtemp[i] = '\n';
		return mingwen;								//返回明文
	}
	public static void main(String[] args) throws IOException {
		
		int n;
		char[] srcstr = new char[100];
		char[] miwen;
		String go = null;
		
		System.out.println("换位加密解密算法演示！");
		
		do {
			System.out.print("请先输入换位加密矩阵每行的字符数：");
			Scanner input = new Scanner(System.in);
			n = input.nextInt();						//输入换位加密矩阵每行的字符数
			
			System.out.println("请输入明文：");
			
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
			String str = bufferedReader.readLine();
			srcstr = str.toCharArray();
			
			System.out.print("输入的明文为：");
			for (int i = 0; i < srcstr.length; i++) {
				System.out.print(srcstr[i]);
			}
			
			miwen = jiami(srcstr, n);					//加密
			System.out.print("\n 加密后的明文是：");
			for (int i = 0; i < srcstr.length; i++) {
				System.out.print(miwen[i]);
			}
			
			miwen = jiemi(miwen, n);					//解密
			System.out.print("\n 解密出的明文为：");		
			for (int i = 0; i < srcstr.length; i++) {
				System.out.print(miwen[i]);
			}
			
			System.out.print("\n 继续执行(y/n)");
			
			go = input.next();
		} while (go.equalsIgnoreCase("y"));
		
		System.out.println("演示到此结束！！！！");
	}

}
