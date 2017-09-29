package tiger;

import animal.IAnimal;

public class TestInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IAnimal ia = new Tiger();		//接口向上转型
		ia.sing();
		Tiger tiger = (Tiger)ia;		//接口向下转型
		tiger.getHead();
		tiger.sing();
	}

}
