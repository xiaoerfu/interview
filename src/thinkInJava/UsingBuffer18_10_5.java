package thinkInJava;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

public class UsingBuffer18_10_5 {

	private static void symmetricScramble(CharBuffer buffer){
		while (buffer.hasRemaining()) {
			buffer.mark();
			char c1 = buffer.get();
			char c2 = buffer.get();
			buffer.reset();
			//交换字符格式
			buffer.put(c2).put(c1);
		}
	}
	public static void main(String[] args) {
		// 其中data必须为双数的
		char[] data = "UsingBuffers".toCharArray();
		ByteBuffer bb = ByteBuffer.allocate(data.length * 2);
		CharBuffer cb = bb.asCharBuffer();
		cb.put(data);
		System.out.println(cb.rewind());
		symmetricScramble(cb);
		System.out.println(cb.rewind());
		symmetricScramble(cb);
		System.out.println(cb.rewind());
	}

}
