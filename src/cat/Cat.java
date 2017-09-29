package cat;

import animal.Animal;

public class Cat extends Animal{
	
	private String eyes = "2";
	
	public String getEyes(){
		return "Cat-Eyes" + eyes;
	}

}
