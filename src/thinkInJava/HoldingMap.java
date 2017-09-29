package thinkInJava;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author lijianfu
 * Map键值对存储
 */
public class HoldingMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random = new Random(47);
		Map<Integer, Integer> m = 
				new HashMap<Integer,Integer>();
		for(int i = 0; i < 10000; i++){
			int r = random.nextInt(20);		//0~20之间的键
			Integer freq = m.get(r);
			m.put(r, freq == null ? 1 : freq + 1);
		}
		System.out.println(m);
	}

}
