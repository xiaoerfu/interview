package thinkInJava.enumtest;

import java.util.EnumMap;
import java.util.Map;

/**
 * EnumMap是一种特殊的Map，他要求其中的键（key）必须是来自一个enum。
 * 由于enum本身的限制，所以在EnumMap在内部可以由数组实现，所以EnumMap的速度很快。
 * 下面的演示使用了命令行模式用法
 * @author lijianfu
 * 2017年12月7日
 * 上午10:21:47
 */

//public enum AlarmPoints{
//	ONE,TWO,THEREE
//}
interface Command{
	void action();
}

public class EnumSetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EnumMap<AlarmPoints, Command> em = 
				new EnumMap<AlarmPoints, Command>(AlarmPoints.class);
		em.put(AlarmPoints.ONE, new Command(){

			@Override
			public void action() {
				// TODO Auto-generated method stub
				System.out.println("ONE fire!");
			}
			
		});
		em.put(AlarmPoints.TWO, new Command(){

			@Override
			public void action() {
				// TODO Auto-generated method stub
				System.out.println("TWO alert!");
			}
			
		});
		
		for (Map.Entry<AlarmPoints, Command> e : em.entrySet()) {
			System.out.print( e.getKey() + ":");
			e.getValue().action();
		}
		try {
			em.get(AlarmPoints.THREE).action();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
