package thinkInJava.enumtest;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Set;
import java.util.TreeSet;

/**
 * 利用反射机制，查看enum中是否是含有values()方法
 * @author lijianfu
 * 2017年12月6日
 * 上午9:19:07
 */

enum Explore{ HERE, THERE }

public class Reflection {
	
	public static Set<String> analyze(Class<?> enumClass){
		System.out.println("--------Analyzing" + enumClass + "--------");
		System.out.println("Interface:");
		for (Type t : enumClass.getGenericInterfaces())
			System.out.print(t + " ");
			System.out.println("Base:" + enumClass.getSuperclass());
			System.out.println("Methods:");
			Set<String> methods = new TreeSet<String>();
		for (Method m : enumClass.getMethods()) {
			methods.add(m.getName());
			System.out.print(methods + " ");
		}
		return methods;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> exploreMethods = analyze(Explore.class);
		Set<String> enumMethods = analyze(Enum.class);
		System.out.println("Expolre.containsAll(Enum?)" 
				+ exploreMethods.contains(enumMethods) );
		System.out.print("Expolre.removeAll(Enum):");
		exploreMethods.removeAll(enumMethods);
		System.out.print(exploreMethods + " ");
		
	}

}
