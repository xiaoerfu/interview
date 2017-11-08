package generics;

/**
 * 多种类型参数方法
 * @author lijianfu
 * 2017年11月7日
 * 下午1:42:06
 */
public class MultipleTypeParameters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Box3<Integer, String> box = new Box3<Integer, String>();
		box.add(Integer.valueOf(100), "hello world");
		System.out.printf("Integer value : %d\n", box.getFirst());
		System.out.printf("String value : %s\n", box.getSecond());		

		Box3<String, String> box1 = new Box3<String, String>();
		box1.add("101", "hello world+1");
		System.out.printf("Integer value : %s\n", box1.getFirst());
		System.out.printf("String value : %s\n", box1.getSecond());		
	}

}

class Box3<T, S>{
	private T t;
	private S s;
	
	public void add(T t, S s){
		this.t = t;
		this.s = s;
	}
	
	public T getFirst(){
		return t;
	}
	
	public S getSecond(){
		return s;
	}
}