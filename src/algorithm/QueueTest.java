package algorithm;

import java.util.Scanner;

/**
 * 队列操作
 * @author lijianfu
 * 2017年11月17日
 * 上午8:43:21
 */

class Data4{
	String name;
	int age;
}

class SQType{
	static final int QUEUELEN = 15;
	Data4[] data = new Data4[QUEUELEN];				//队列数组
	int head;											//队头
	int tail;											//队尾
	
	@SuppressWarnings("unused")
	SQType SQTypeInit(){								//初始化
		SQType q;
		if ((q = new SQType()) != null) {				//申请内存
			q.head = 0;									//设置队头为0
			q.tail = 0;									//设置队尾为0
			return q;
		}else{
			return null;								//返回null
		}
	}
	
	int SQTypeIsEmpty(SQType q){						//判断是否为空队列
		int temp = 0;
		if (q.head == q.tail) {
			temp = 1;
		}
		return (temp);
	}
	
	int SQTypeIsFull(SQType q){						//判断是否为满队列
		int temp = 0;
		if (q.tail == QUEUELEN) {
			temp = 1;
		}
		return (temp);
	}
	
	void SQTypeClear(SQType q){						//清空队列，设置队头和队尾为0
		q.head = 0;
		q.tail = 0;
	}
	
	void SQTypeFree(SQType q){							//释放内存
		if (q != null) {
			q = null;
		}
	}
	
	int InSQType(SQType q, Data4 data){				//入队
		if (q.tail == QUEUELEN) {
			System.out.println("队列已满，不能入队！");
			return 0;
		}else{
			q.data[q.tail++] = data;					//将元素入队列
			return 1;
		}
	}
	
	Data4 OutSQType(SQType q){							//出列
		if (q.head == q.tail) {
			System.out.println("队列为空，出列失败！");
			System.exit(0);
		}else{
			return q.data[q.head++];
		}
		return null;
	}
	
	Data4 ReadSQType(SQType q){						//读取结点数据内容
		if (SQTypeIsEmpty(q) == 1) {
			System.out.println("队列为空，不能操作！");
			return null;
		}else{
			return q.data[q.head];
		}
	}
	
	int SQTypeLen(SQType q){							//计算队列长度
		int temp;
		temp = q.tail - q.head;
		return temp;
	}
	
}
public class QueueTest {

	public static void main(String[] args) {
		
		SQType st = new SQType();
		
		Data4 data1;
		
		Scanner input = new Scanner(System.in);
		SQType stack = st.SQTypeInit();					//初始化队列
		System.out.println("现在进行如队列操作: 输入姓名 年龄进行入队列操作");
		do {
			Data4 data = new Data4();
			data.name = input.next();
			data.age = input.nextInt();
			if (data.name.equals("0")) {
				break;
			}else{
				st.InSQType(stack, data);
			}
		} while (true);
		
		
		String temp = "1";
		System.out.println("出队列操作：按任意非0键进行出队列操作");
		temp = input.next();
		while (!temp.equals("0")) {
			data1  = st.OutSQType(stack);
			System.out.printf("出队列的数据是：（%s，%d）",data1.name,data1.age);
			temp = input.next();
		}
		System.out.println("测试结束");
		st.SQTypeFree(stack); 								//释放队列内存
	}

}
