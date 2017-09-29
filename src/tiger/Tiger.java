package tiger;

import animal.IAnimal;

public class Tiger implements IAnimal {

	private String head = "1";
	
	public void getHead(){
		System.out.println("Tiger-head" + head); 
	}

	@Override
	public void sing() {
		// TODO Auto-generated method stub
		System.out.println("越努力，越幸运！"); 
	}

}
