package animal;

import cat.Cat;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal a = new Cat();		//父类向上转型
		a.getHead();
		Cat cat = (Cat)a;			//向下转型
		cat.getEyes();
		cat.getHead();
	}

}
