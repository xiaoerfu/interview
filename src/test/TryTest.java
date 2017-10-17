package test;

public class TryTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(test());
	}

	@SuppressWarnings("finally")
	private static int test() {
		int b = 20;

        try {
            System.out.println("try block");
            System.out.println(b);
            return b += 80;
            
        } catch (Exception e) {

            System.out.println("catch block");
        } finally {

            System.out.println("finally block");

            if (b > 25) {
                System.out.println("b>25, b = " + b);
            }

            return 0x31&0x0f;
        }

        // return b;
    }

}
