package thinkInJava;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/**
 * 字节存放数据次序
 * @author lijianfu
 * 2017年11月13日
 * 上午10:46:06
 */
public class Endians18_1 {

	public static void main(String[] args) {
		// 1、设置数组
		ByteBuffer bb = ByteBuffer.wrap(new byte[12]);
		// 2、存入数据
		bb.asCharBuffer().put("abcdef");
		// 3、打印
		System.out.println(Arrays.toString(bb.array()));
		// 1、设置读写模式
		bb.rewind();
		// 2、设置地位存入
		bb.order(ByteOrder.BIG_ENDIAN);
		// 3、存入数据
		bb.asCharBuffer().put("abcdef");
		// 4、打印
		System.out.println(Arrays.toString(bb.array()));
		// 1、设置读写模式
		bb.rewind();
		// 2、设置地位存入
		bb.order(ByteOrder.LITTLE_ENDIAN);
		// 3、存入数据
		bb.asCharBuffer().put("abcdef");
		// 4、打印
		System.out.println(Arrays.toString(bb.array()));
	}

}
