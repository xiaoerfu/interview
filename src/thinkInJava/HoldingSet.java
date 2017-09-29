package thinkInJava;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @author lijianfu
 * Set不保存重复的元素，具有与Collection完全一样的接口
 */
public class HoldingSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random = new Random(47);
		Set<Integer> intset = new HashSet<Integer>();
		for(int i = 0; i < 10000; i++){
			intset.add(random.nextInt(30));
			System.out.println(intset);
		}
	}

}
