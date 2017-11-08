package generics;


class Box<T>{
	private T t;
	
	public void add(T t){
		this.t = t;
	}
	
	public T get(){
		return t;
	}
}

public class GenericsClasses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Box<Integer> integerBox = new Box<Integer>();
		Box<String> stringBox = new Box<String>();
		
		integerBox.add(new Integer(100));
		stringBox.add(new String("努力就会幸运"));
		
		System.out.printf("Integer Value: %d\n", integerBox.get());
		System.err.printf("String Value: %s\n", stringBox.get());
	}
	
}
