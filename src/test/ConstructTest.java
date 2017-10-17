package test;

public class ConstructTest {

	String name;
	
	public ConstructTest(String input) {
		// TODO Auto-generated constructor stub
		name = input;
		System.out.println(name);
	}
	
	public ConstructTest() {
		// TODO Auto-generated constructor stub
		this("xiaoerfu");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConstructTest c1 = new ConstructTest("人生就要闯一闯");
		ConstructTest c2 = new ConstructTest();
	}

}
