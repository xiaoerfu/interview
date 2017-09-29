package test;

public class Drinking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int sum = 0;
		int temp = 1;
		int[] x = new int[10];
		for(int i=50; i>0; i--){
			if (temp == 3) {
				temp = 1;
				i++;
			}else{
				temp++;
			}
			sum++;
		}
		System.out.println("总共喝了" + sum + "瓶啤酒");
		System.out.println(x[9]);
	}


}
