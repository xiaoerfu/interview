package thinkInJava.enumtest;

/**
 * 将enum实例向上转型为Enum，那么values（）方法就不能访问了
 * 但还是可以使用getEnumConstants（）方法获取其values（）方法，列出enum实例
 * @author lijianfu
 * 2017年12月6日
 * 下午3:14:37
 */
enum Search { ONE, TWO }

public class UpcastEnum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Search[] val = Search.values();
		Enum e = Search.ONE;				//Upcast
		// e.values();						//no values() in Enum
		for (Enum en : e.getClass().getEnumConstants()) {
			System.out.println(en);
		}
	}

}
