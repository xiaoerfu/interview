package thinkInJava;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Random;
/**
 * 序列化一个对象
 * @author lijianfu
 * 2017年11月28日
 * 上午8:59:56
 */
class Data implements Serializable{
	private int n;
	public Data(int n){this.n = n;}
	public String toString(){return Integer.toString(n);}
}

public class Worm_18 implements Serializable{

	private static Random rand = new Random(47);
	private Data[] d = {
			new Data(rand.nextInt(10)),
			new Data(rand.nextInt(10)),
			new Data(rand.nextInt(10)),
	};
	private Worm_18 next;
	private char c;
	public Worm_18(int i, char x){
		System.out.println("Worm constructor:" + i);
		c = x;
		if (--i > 0) {
			next = new Worm_18(i, (char)(x+1));
		}
	}
	
	public  Worm_18(){
		System.out.println("Defalut constructor");
	}
	
	public String toString(){
		StringBuilder result = new StringBuilder(":");
		result.append(c);
		result.append("(");
		for (Data data : d) {
			result.append(data);
		}
		result.append(")");
		if (next != null) {
			result.append(next);
		}
		return result.toString();
	}
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {

		Worm_18 w = new Worm_18(6, 'a');
		System.out.println("W = " + w);
		//1、序列化一个对象，创建一个outputStream,将对象封装在一个ObjectOutputStream内
		ObjectOutputStream out = new ObjectOutputStream(
				new FileOutputStream("C:/Users/lijianfu/Desktop/test.txt"));
		//2、调用writeObject（）即可以将对象序列化
		out.writeObject("Worm storage\n");
		out.writeObject(w);
		out.close();
		ObjectInputStream in = new ObjectInputStream(
				new FileInputStream("C:/Users/lijianfu/Desktop/test.txt"));
		String s = (String)in.readObject();
		Worm_18 w2 = (Worm_18)in.readObject();
		System.out.println(s + "w2 = " + w2);
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		ObjectOutputStream out2 = new ObjectOutputStream(bout);
		out2.writeObject("Worm storage\n");
		out2.writeObject(w);
		out2.flush();
		ObjectInputStream in2 = new ObjectInputStream(new ByteArrayInputStream(bout.toByteArray()));
		s = (String)in2.readObject();
		Worm_18 w3 = (Worm_18)in2.readObject();
		System.out.println(s + "w3 = " + w3);
	}

}
