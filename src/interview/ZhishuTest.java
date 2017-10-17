package interview;

import java.util.Scanner;

/**
 * 求100-201之间的素数（实质是质数）
 * @author lijianfu
 *
 */
public class ZhishuTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int count = 0;
//		boolean b = true;
//		for(int i = 100; i <= 201; i++){	
//			System.out.print(i + " ");
//			for(int j = 2; j <= i; j++){
//			System.out.print(j + " ");
//				if(i % j == 0){
//					b = false;
//					break;
//				}
//			}
//			if(b){
//				System.out.println("素数是：" + i);
//				count++;
//				System.out.println("素数的个数是：" + count);
//			}
//			b = true;
//		}
//		System.out.println("素数的个数是：" + count);
//	}
		System.out.println("请输入所求素数范围");
//        Scanner in = new Scanner(System.in);  
//        int x;  
//        x = in.nextInt();  
        boolean isprime = true;  
        int count = 0;
        for (int i = 100; i <= 201; i++) {  
            for(int j = 2; j < i; j++) {  
                  if(i % j == 0)            {  
                    isprime = false;  
                    break;  
                  }  
            }  
            if(isprime){      
            System.out.print(i + " ");  
            count++;
            }
            isprime = true;             
        } 
        System.out.println();
        System.out.println("素数：" + count);
          
//测试结果：           100  
//             2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97          
//             
	}  
}
