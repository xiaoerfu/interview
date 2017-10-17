package interview;

public class Arithmetic4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "woa123如果有一天@you$%";
		int english = 0;
		int chineseCount = 0;
		int digitCount = 0;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch >= '0' && ch <= '9') {
				digitCount++;
			}else if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
				english++;
			}else{
				chineseCount++;
			}
		}
		System.out.println("英文字符：" + english 
				+ ",中文字符：" + chineseCount
				+ ",数字字符：" + digitCount);
	}

}
