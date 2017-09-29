package test;

public class Bground extends Thread{
    public static void main(String argv[]){
        Bground b = new Bground();
        b.start();
        int a = '2';
        System.out.println(a);
        Bground.ad();
    }
    public void start(){
        for(int i=0;i<10;i++){
            System.out.println("Value of i = "+i);
        }

    }
    
    public static void ad(){
    	
    }
}