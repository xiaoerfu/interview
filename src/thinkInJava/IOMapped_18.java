package thinkInJava;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;

/**
 * I/O流中几种访问文件的方式时间大小比较
 * @author lijianfu
 * 2017年11月20日
 * 下午5:32:31
 */
public class IOMapped_18 {

	private static int numOfInts = 4000000;
	private static int numOfUbufferInts = 200000;
	
	//定义一个抽象方法，计算读取文件时所用的时间
	private abstract static class Tester{
		private String name;
		public Tester(String name){
			this.name = name;
		}
		public void runTest(){
			System.out.print(name + ": ");
			try {
				long start = System.nanoTime();
				test();
				double duration = System.nanoTime() - start;
				System.out.format("%.2f\n", duration/1.0e9);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		public abstract void test() throws IOException;
	}
	
	//定义数组，利用内部类实现读取文件内容
	private static Tester[] tests = {
		new Tester("Stream Write"){
			public void test() throws IOException{
				DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(
						new FileOutputStream(new File("C:/Users/lijianfu/Desktop/hello.cpp"))));
				for (int i = 0; i < numOfInts; i++) {
					dos.writeInt(i);
				}
				dos.close();
			}
		},	
		
		new Tester("Map Write"){
			public void test() throws IOException{
				@SuppressWarnings("resource")
				FileChannel fc = new RandomAccessFile("C:/Users/lijianfu/Desktop/hello.cpp","rw").getChannel();
				IntBuffer ib = fc.map(FileChannel.MapMode.READ_WRITE, 0, fc.size()).asIntBuffer();
				for (int i = 0; i < numOfInts; i++) {
					ib.put(i);
				}
				fc.close();
			}
		},
		
		new Tester("Stream Read"){
			public void test() throws IOException{
				DataInputStream dis = new  DataInputStream(
						new BufferedInputStream(
								new FileInputStream("C:/Users/lijianfu/Desktop/hello.cpp")));
				for (int i = 0; i < numOfInts; i++) {
					dis.readInt();
				}
				dis.close();
			}
		},
		
		new Tester("Map Read"){
			public void test() throws IOException{
				@SuppressWarnings("resource")
				FileChannel fc = new FileInputStream(
						new File("C:/Users/lijianfu/Desktop/hello.cpp")).getChannel();
				IntBuffer ib = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size()).asIntBuffer();
				while(ib.hasRemaining()){
					ib.get();
				}
				fc.close();
			}
		},
		
		new Tester("Stream Write/Read"){
			public void test() throws IOException{
				RandomAccessFile raf = new RandomAccessFile(
						new File("C:/Users/lijianfu/Desktop/hello.cpp"), "rw");
				raf.writeInt(1);
				for (int i = 0; i < numOfUbufferInts; i++) {
					raf.seek(raf.length() - 4);
					raf.writeInt(raf.readInt());
				}
				raf.close();
			}
		},
		
		new Tester("Mapped Read/Write"){
			public void test() throws IOException{
				@SuppressWarnings("resource")
				FileChannel fc = new RandomAccessFile(
						new File("C:/Users/lijianfu/Desktop/hello.cpp"), "rw").getChannel();
				IntBuffer ib = fc.map(FileChannel.MapMode.READ_WRITE, 0, fc.size()).asIntBuffer();
				ib.put(0);
				for (int i = 1; i < numOfUbufferInts; i++) {
					ib.put(ib.get(i-1));
				}
				fc.close();
			}
		}
	};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (Tester test : tests) {
			test.runTest();
		}
	}


}
