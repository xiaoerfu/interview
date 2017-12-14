package thinkInJava.anotation;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 通过反射机制找到PasswordUtils中的用例和缺失的用例。
 * @author lijianfu
 * 2017年12月8日
 * 上午9:11:32
 */
public class UseCaseTracker {

	public static void 
	trackUseCases(List<Integer> useCases, Class<?> cl){
		for (Method m : cl.getDeclaredMethods()) {
			UseCase uc = m.getAnnotation(UseCase.class);
			if (uc != null) {
				System.out.println("Found Use Case : " + uc.id() + 
						", " + uc.description());
				useCases.remove(new Integer(uc.id()));
			}
		}
		for (int  i : useCases) {
			System.out.println("Warning : Missiong use case-" + i);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> useCase = new ArrayList<Integer>();
		Collections.addAll(useCase, 47, 48, 49, 50);
		trackUseCases(useCase, PasswordUtils.class);
	}

}
