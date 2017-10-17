package test;

public class StringBUfferAndString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long begintime = System.currentTimeMillis();
		StringBuilder stringBuilder = new StringBuilder();
		for(int i = 0; i < 2000; i++){
			stringBuilder.append(i);
		}
		System.out.println(stringBuilder);
		System.out.println("StringBuilder 总共执行时间为："+(System.currentTimeMillis()-begintime)+"毫秒");
		
		StringBuffer stringBuffer = new StringBuffer();
		for(int i = 0; i < 2000; i++){
			stringBuffer.append(i);
		}
		System.out.println(stringBuffer);
		System.out.println("StringBuffer 总共执行时间为："+(System.currentTimeMillis()-begintime)+"毫秒");
		
		String str = new String();
		for(int i = 0; i < 2000; i++){
			str = str + i;
		}
		System.out.println(str);
		System.out.println("String 总共执行时间为："+(System.currentTimeMillis()-begintime)+"毫秒");
	}

}
