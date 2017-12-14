package algorithm.cryptography;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLockInterruptionException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Scanner;
import java.util.zip.ZipOutputStream;

/**
 * 利用LZW压缩和解压缩算法进行文件的压缩和解压缩
 * @author lijianfu
 * 2017年12月12日
 * 下午4:06:39
 */
public class Unzip {

	Dictionary dic = new Dictionary();
	int count1 = 0,count2 = 0;
	BufferedInputStream in;
	BufferedOutputStream out;
	final short END = 4095;
	
	public static void main(String[] args) {
		String[] args1 = {"-c", "C:/Users/lijianfu/Desktop/2.txt", "s1.mz"};
		String[] args2 = {"-d", "s1.mz", "t2.txt"};
		String[] args3;
		Scanner input = new Scanner(System.in);
		System.out.println("解压缩算法演示：");
		String go;
		do {
			System.out.print("请输入功能（0：压缩， 1：解压缩）");
			int s = input.nextInt();
			if (s == 0) {
				args3 = args1;
			}else{
				args3 = args2;
			}
			Unzip a = new Unzip(args3);
			a.run(args3);
			System.out.println("继续执行（y/n）");
			go = input.next();
		} while (go.equalsIgnoreCase("y"));
		System.out.println("演示结束！！");
		return;
	}
	
	public Unzip(String[] args){
		try {
			String f = new String();
			in = new BufferedInputStream(new FileInputStream(new File(args[1])));
			if (args.length == 3 && !args[2].equals(new String("-dic"))) {
				f = args[2];
			}else{
				int i = args[1].lastIndexOf(new String("."));
				f = args[1].substring(0, i)+((args[0].equals("-c"))?".lzw":".dlzw");
			}
			out = new BufferedOutputStream(new FileOutputStream(new File(f)));
		} catch (FileNotFoundException e) {
			System.out.println(e);
			System.out.println("文件没有找到！！！");
			return;
		} catch(IOException e){
			System.out.println(e);
			return;
		}
	}
	
	public void run(String args[]){
		if (args[0].equals(new String("-c"))) {
			code(in, out);
		} else {
			decode(in, out);
		}
		if (args[args.length-1].equals(new String("-dic"))) {
			System.out.println(dic.toString());
		}
	}

	private void code(BufferedInputStream in2, BufferedOutputStream out2) {
		// TODO Auto-generated method stub
		System.out.println("coding......\n" + "......\n");
		byte a[] = new byte[1], buf[] = new byte[3];
		
		String prefix = "", cur = "";
		byte i = 0;
		short indexbuf[] = new short[2];
		
		String str = null;
		try {
			short m = 0;
			while ((a[0] = (byte)in.read()) != -1) {
				cur = new String(a);
				count1++;
				str = prefix;
				str = str.concat(cur);
				m = (short)dic.indexOf(str);
				
				if (m != -1) {
					prefix = str;
				}else{
					if (i == 0) {
						indexbuf[0] = (short) dic.indexOf(prefix);
						i = 1;
					}else{
						indexbuf[1] = (short) dic.indexOf(prefix);
						zipOutput(out,indexbuf);
						
						count2 += 3;
						i = 0;
					}
					dic.add(str);
					prefix = cur;
				}
			}
			if (i == (byte)1) {
				indexbuf[1] = END;
				zipOutput(out, indexbuf);
				count2 += 3;
			}
			dic.add(str);
			in.close();
			out.close();
			System.out.println("zip rate:" + (float)count2 * 100/count1 + "%");
		} catch (IOException e) {
			// TODO: handle exception
			System.err.println(e);
			return;
		} catch (OutDictionaryException e){
			System.err.println(e);
			return;
		}
	}
	
	private void zipOutput(BufferedOutputStream out2, short[] indexbuf) {
		// TODO Auto-generated method stub
		try {
			byte buf[] = new byte[3];
			buf[1] = (byte)(indexbuf[0] << 4);
			buf[0] = (byte)(indexbuf[0] >> 4);
			buf[2] = (byte) indexbuf[1];
			buf[1]+=(byte)(indexbuf[1] >> 8);
			out.write(buf, 0, 3);
		} catch (IOException e) {
			// TODO: handle exception
			System.err.println(e);
			return;
		}
	}

	private void decode(BufferedInputStream in2, BufferedOutputStream out2) {
		// TODO Auto-generated method stub
		System.out.println("decoding......\n" + ".......\n");
		
		short precode = 0, curcode = 0;
		String prefix = null;
		short i = 0;
		short bufcode[] = new short[2];
		boolean more = true;
		try {
			more = zipInput(in, bufcode);
			if (more) {
				curcode = bufcode[0];
				stringOut(out, dic.getString(curcode));
				
			}else 
				System.out.println("error in the beginning....");
			while (more) {
				precode = curcode;
				if (i == 0) {
					curcode = bufcode[1];
					i = 1;
				}else {
					more = zipInput(in2, bufcode);
					curcode = bufcode[0];
					if (bufcode[1] == END) {
						stringOut(out, dic.getString(curcode));
						break;
					}
					i = 0;
				}
				if (curcode < dic.length()) {
					stringOut(out, dic.getString(curcode));
					prefix = dic.getString(precode);
					
					prefix+=(dic.getString(curcode)).substring(0, 1);
					dic.add(prefix);
				}else{
					prefix = dic.getString(precode);
					prefix += prefix.substring(0, 1);
					stringOut(out, prefix);
					dic.add(prefix);
				}
			}
			
			in.close();
			out.close();
			System.out.println("decode finished!!!");
		} catch (OutDictionaryException e) {
			System.err.println(e);
			return;
		} catch (IOException e){
			System.err.println(e);
			return;
		}
	}
	
	private void stringOut(BufferedOutputStream out2, String str) {
		// TODO Auto-generated method stub
		byte a[] = str.getBytes();
		try {
			out2.write(a, 0, str.length());
		} catch (IOException e) {
			// TODO: handle exception
			System.err.println(e);
		}
	}

	private boolean zipInput(BufferedInputStream in2, short[] bufcode) {
		// TODO Auto-generated method stub
		byte buf[] = new byte[3], temp;
		short le = (short) dic.length();
		try {
			if (in.read(buf, 0, 3) != 3) {
				System.out.println("the end of the file !");
				return false;
			}
			bufcode[0] = toRight(buf[0], 4);
			bufcode[0] += (short)(toRight(buf[1], 0) >> 4);
			
			bufcode[1] = toRight(buf[2],0);
			temp = (byte)(toRight(buf[1], 4));
			bufcode[1] += toRight(temp, 4);
			if (bufcode[0] < -1 || bufcode[1] < -1) {
				System.out.println("erroring while getting the code:" + bufcode[0] + "\t" + bufcode[1]);
				System.out.println(dic);
				return false;
			}
		} catch (IOException e) {
			// TODO: handle exception
			System.err.println(e);
			return false;
		}
		return true;
	}

	private short toRight(byte buf, int n) {
		// TODO Auto-generated method stub
		short s = 0;
		for (short i = 7; i >= 0; i--) {
			if (((1L << i) & buf) != 0) {
				s += (short)(1L << (i+n));
			}
			return s;
		}
		return 0;
	}

	class OutDictionaryException extends Exception{

		public String toString(){
			return (super.toString() + "out of the dictionary size!!!");
		}
	}
	
	class Dictionary{
		ArrayList ar = new ArrayList();
		
		public Dictionary(){
			char c[] = new char[1];
			for (c[0] = 0; c[0] < 128; c[0]++) {
				ar.add(new String(c));
			}
		}
		
		public int indexOf(String a){
			return ar.indexOf(a);
		}
		
		public void add (String a)throws OutDictionaryException{
			if (length() < 4096) {
				ar.add(a);
			}else{
				throw(new OutDictionaryException());
			}
		}

		private int length() {
			// TODO Auto-generated method stub
			return (short)ar.size();
		}
		
		public String toString(){
			Integer le = new Integer(length());
			String str = "size of the dictionary:" + le.toString() + "\n";
			for (int i = 0; i < length(); i++) {
				str+=new String(i + ":" + (String)ar.get(i) + "\t");
			}
			return str;
		}
		
		public String getString(short i){
			return (String)ar.get(i);
		}
	}

}
