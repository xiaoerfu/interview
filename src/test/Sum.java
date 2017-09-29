package test;

public class Sum {
	static boolean Paddy;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int  b[][]={{1}, {2,2}, {2,2,2}};

		 int sum=0;

		 for(int i=0;i<b.length;i++) {

		     for(int j=0;j<b[i].length;j++) {

		         sum+=b[i][j];

		     }

		 } 
		 System.out.println(sum);
		 System.out.println(Paddy);
		 String str="123456";
		 int i=Integer.parseInt(str);
		 System.out.println(i);
	}

}
