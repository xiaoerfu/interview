package test;

public class Sum {
	static boolean Paddy;
	 public static int staticVar = 0;

 
     
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    int instanceVar = 0;
		 int  b[][]={{1}, {2,2}, {2,2,2}};

		 int sum=0;

		 for(int i=0;i<b.length;i++) {

		     for(int j=0;j<b[i].length;j++) {

		         sum+=b[i][j];

				 
				 staticVar++;

		         instanceVar++;
		     }

		 } 
		 System.out.println(sum);
		 System.out.println(Paddy);
		 String str="123456";
		 int i=Integer.parseInt(str);
		 System.out.println(i);


         System.out.println("staticVar="+ staticVar + ",instanceVar=" + instanceVar);
         
         Math.random();
         
         
		 
	}

}
