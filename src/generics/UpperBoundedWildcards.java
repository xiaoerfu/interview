package generics;

import java.util.Arrays;
import java.util.List;

/**\
 *  问号(?)表示通配符，代表未知类型的泛型。
  	有时候您可能希望限制允许传递给类型参数的类型。 
  	例如，对数字进行操作的方法可能只希望接受Number类或其子类的实例。
	要声明一个上限通配符参数，首先列出问号 ? 
	然后跟上extend关键字，之后再指定其上限。
 * @author lijianfu
 * 2017年11月7日
 * 下午3:30:21
 */
public class UpperBoundedWildcards {

	public static double sum (List<? extends Number> numberList){
		double sum = 0.0;
		for (Number number : numberList) {
			sum = sum + number.doubleValue();
		}
		return sum;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> integerList = Arrays.asList(10, 12, 18);
		System.out.println("sum = " + sum(integerList));
		
		List<Double> doubleList = Arrays.asList(11.2, 32.3, 53.7);
        System.out.println("sum = " + sum(doubleList));
	}

}
