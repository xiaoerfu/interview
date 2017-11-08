package generics;

public class MultipleBounds {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.printf("Max of %d, %d and %d is %d\n\n", 30, 24, 15,
                maximum(30, 24, 15));

        System.out.printf("Max of %.1f,%.1f and %.1f is %.1f\n\n", 16.6, 28.8,
                17.7, maximum(16.6, 28.8, 17.7));
        
//        System.out.printf("Max of %s, %s and %s is %s\n", "pear", "apple",
//                "orange", maximum("pear", "apple", "orange"));
	}

	private static <T extends Number & Comparable<T>> T maximum(T x, T y, T z) {
		T max = x;
		if (y.compareTo(max) > 0) {
			max = y;
		}
		if (z.compareTo(max) > 0) {
			max = z;
		}
		return max;
	}

}
