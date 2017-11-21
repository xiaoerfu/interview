package algorithm;

import java.util.Scanner;

/**
 * 栈操作
 * @author lijianfu
 * 2017年11月16日
 * 下午4:15:58
 */

class Data3{								//定义属性
	String name;
	int age;
}

class StackType{
	static final int MAXLEN = 50;			//最大长度
	Data3 data[] = new Data3[MAXLEN+1];		//数据元素
	int top;								//栈顶
	
	@SuppressWarnings("unused")
	StackType STInit(){						//初始化站内容
		StackType p;
		if ((p = new StackType()) != null) {	//申请栈内存
			p.top = 0;							//设置栈顶为0
			return p;							//返回指向栈的引用
		}
		return null;
	}
	
	boolean STIsEmpty(StackType s){			//判断是否为空栈
		boolean t;
		t = (s.top == 0);
		return t;
	}
	
	boolean STIsFull(StackType s){				//判断是否为满栈
		boolean t;
		t = (s.top == MAXLEN);
		return t;
	}
	
	void STClear(StackType s){					//清空栈
		s.top = 0;
	}
	
	void STFree(StackType s){					//释放栈所占的空间
		if (s != null) {
			s = null;
		}
	}
	
	int PushST(StackType s, Data3 data){		//入栈操作
		//1、判断是否栈满
		if ((s.top+1) > MAXLEN) {
			System.out.println("栈已满");
			return 0;
		}
		//2、入栈
		s.data[++s.top] = data;
		return 1;
	}
	
	Data3 PopST(StackType s){					//出栈操作
		if(s.top == 0){
			System.out.println("栈是空栈");
			System.exit(0);
		}
		return s.data[s.top--];
	}
	
	Data3 PeekST(StackType s){					//读取栈顶操作
		if (s.top == 0) {
			System.out.println("栈为空栈");
			System.exit(0);
		}
		return(s.data[s.top]);
	}
}
public class StackTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackType st = new StackType();
		Data3 data1 = new Data3();
		
		//初始化栈
		StackType stack = st.STInit();
		if (st.STIsEmpty(stack)) {
			System.out.println("目前栈为空");
		}
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("入栈操作： 输入姓名 年龄进行入栈操作");
		do {
			Data3 data = new Data3();
			data.name = input.next();
			
			if (data.name.equals("0")) {
				break;
			}else{
				data.age = input.nextInt();
				st.PushST(stack, data);
			}
		} while (true);
		String temp = "";
		System.out.println("出栈操作，按任意非0键进行出栈操作~~~");
		temp = input.next();
		while (!temp.equals("0")) {
			data1 = st.PopST(stack);
			System.out.println("出栈的数据是" + data1.name + "、" + data1.age);
			temp = input.next();
		}
		System.out.println("测试结束！");
		st.STFree(st);								//释放栈内存
		
	}

}
