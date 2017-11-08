package generics;


/**
 * 泛型原始化类型
 * @author lijianfu
 * 2017年11月7日
 * 下午2:11:24
 */
public class RawTypes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Box5<Integer> integerBox = new Box5<Integer>();
		Box5<String> stringBox = new Box5<String>();
		
		integerBox.add(new Integer(105));
		stringBox.add(new String("努力就会幸运"));
		
		System.out.printf("Integer Value: %d\n", integerBox.get());
		System.err.printf("String Value: %s\n", stringBox.get());
		
		Box5 rawBox = new Box5();
		rawBox = integerBox;
		System.out.printf("Integer Value: %d\n", rawBox.get());
	}
	
}


class Box5<T>{
	private T t;
	
	public void add(T t){
		this.t = t;
	}
	
	public T get(){
		return t;
	}
}