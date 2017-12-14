package thinkInJava.anotation;

import java.util.*;
/**
 * 注解的元素在使用时表现为名——值对的形式
 * @author lijianfu
 * 2017年12月8日
 * 上午8:53:12
 */
public class PasswordUtils {

	@UseCase(id = 47,description = 
			"Passwords must contain at least one numeric")
	public boolean validatePassword(String password){
		return (password.matches("\\w*\\d\\w*"));
	}
	
	@UseCase(id = 48)
	public String encryptPassword(String password){
		return new StringBuilder(password).reverse().toString();
	}
	
	@UseCase(id = 49, description = 
			"New passwords can't equal previously used ones")
	public boolean checkForNewPassword(List<String> prevPasswords, String password){
		return !prevPasswords.contains(password);
	}
}
