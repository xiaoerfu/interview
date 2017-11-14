package thinkInJava;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 为了查询快速，利用键对象生成hashcode
 * @author lijianfu
 * 2017年11月9日
 * 下午2:11:58
 */
public class ContainHashCodeTest {

	private static List<String> created = 
			new ArrayList<String>();
	private String s;
	private int id = 0;
	public ContainHashCodeTest(String str){
		s = str;
		created.add(s);
		for (String string : created) {
			if(string.equals(s)){
				id++;
			}
		}	
	}
	
	@Override
	public String toString() {
		return "ContainHashCodeTest [s=" + s + ", id=" + id + ", hashcode=" + hashCode()+ "]";
	}
	
	public int hashCode(){
		int result = 17;
		result = 37 * result + s.hashCode();
		result = 37 * result + id;
		return result;
	}
	
	public boolean equals(Object c){
		return c instanceof ContainHashCodeTest &&
				s.equals(((ContainHashCodeTest)c).s) &&
				id == ((ContainHashCodeTest)c).id;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<ContainHashCodeTest, Integer> map = 
				new HashMap<ContainHashCodeTest, Integer>();
		ContainHashCodeTest[] cs = new ContainHashCodeTest[5];
		for (int i = 0; i < cs.length; i++) {
			ContainHashCodeTest containHashCodeTest = cs[i];
			cs[i] = new ContainHashCodeTest("hi");
			map.put(cs[i], i);
		}
		System.out.println(map);
		for (ContainHashCodeTest containHashCodeTest : cs) {
			System.out.println("looking up" + containHashCodeTest);
			System.out.println(map.get(containHashCodeTest));
		}
	}

}
