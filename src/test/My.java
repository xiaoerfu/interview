package test;

import java.util.Scanner;
/*
两两判断，碰到相同的直接替换就可以，因为有四块砖，保证替换的那块跟它的前面和后面都不相同就可以，所以
一定可以找到一个与前面不同同时与后面不同的替换，因此可以直接替换。
对字符串进行两两判断，找到相邻两个相同的，就将计数器加一，然后直接跳过这两个，从下一个开始判断，就是两两判断
 */
public class My {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        while(sc.hasNext()){
        		String str = sc.next();
        		System.out.println(relace(str));
        	}
        }
    
    private static int relace(String in){
    	int leng = in.length();
    	int count = 0;
    	char[] c = in.toCharArray();
    	for(int i=1; i<leng; i++){
    		if(c[i] == c[i-1]){
    			count++;
    			i++;
    		}
    	}
    	return count;
    }
}