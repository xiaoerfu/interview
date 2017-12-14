package thinkInJava.enumtest;

import java.util.Random;

/**
 * 利用泛型对enum进行随机选择的封装
 * @author lijianfu
 * 2017年12月6日
 * 下午4:17:15
 */
public class Enums {

	private static Random rand = new Random(47);
	public static <T extends Enum<T>> T random(Class<T> ec){
		return random(ec.getEnumConstants());
	}
	private static <T> T random(T[] enumConstants) {
		// TODO Auto-generated method stub
		return enumConstants[rand.nextInt(enumConstants.length)];
	}
}
