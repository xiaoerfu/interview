package thinkInJava.enumtest;

import java.util.EnumSet;

/**
 * 
 * @author lijianfu
 * 2017年12月6日
 * 下午4:07:59
 */

enum Activity{
	A, B, C, D, E, F, G, H, I, J, K, L, M, 
	N, O, P, Q, R, S, T, U, V, W, X, Y, Z
}

public class RandomTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 26; i++) {
			System.out.print(Enums.random(Activity.class) + " ");
		}
	}

}
