package test;

import java.util.Scanner;

public class NiuNiu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		while(s.hasNext()){
			String a = s.next();
			System.out.println(find(a));
		}

	}

	private static int find(String s){
		int res = 0;
		int size = s.length();
		String source = "ATCG";
		char[] ch = s.toCharArray();
		for(int i=0; i<size; i++){
			//			if(ch[i]=='A' || ch[i]=='T' || ch[i]=='C' || ch[i]=='G'){
			//				count++;
			//			}
			//		}
			//		return count;	
			if(source.indexOf(s.charAt(i) + "") != -1) 
			{ 
				int index = i; 
				index++; 
				while(index < s.length() && source.indexOf(s.charAt(index) + "") != -1) 
				{ 
					index++;
				} if((index - i) > res)
				res = index-i;
			}
		}
		return res;
	}

}
