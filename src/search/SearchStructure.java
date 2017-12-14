package search;

import java.util.Scanner;

/**
 * 顺序查找数据结构中的顺序表
 * @author lijianfu
 * 2017年11月22日
 * 上午9:02:09
 */

class Data{									//定义结点关键字
	String key;
	String name;
	int age;
}

class SLType{								//定义顺序表结构
	static final int MAXLEN = 100;
	Data[] ListData = new Data[MAXLEN+1];	//保存顺序表结构数组
	int ListLen;
	
	void SLInit(SLType SL){				//初始化顺序表
		SL.ListLen = 0;						//初始化为空表
	}
	
	int SLLength(SLType SL){				//返回顺序表的元素数量
		return SL.ListLen;
	}
	
	int SLAdd(SLType SL, Data data){		//增加元素到顺序表尾部
		if (SL.ListLen == MAXLEN) {
			System.out.println("顺序表已满，不能再添加节点了！！！");
			return 0;
		}
		SL.ListData[++SL.ListLen] = data;
		return 1;
	}
	
	Data SLFindByNum(SLType SL, int n){	//通过序号返回顺序表中的内容
		if (n<1 || n>SL.ListLen+1) {
			System.out.println("输入的结点序号有误，请重新输入！！！");
			return null;
		}
		return SL.ListData[n];
	}
	
	int SLFindByCount(SLType SL, String key){	//根据关键字返回顺序表内容
		for (int i = 1; i < SL.ListLen; i++) {
			if (SL.ListData[i].key.compareTo(key) == 0) {
				return i;						//返回序号结点
			}
		}
		return 0;
	}
	
	
	int SLAll(SLType SL){						//显示全部内容
		for (int i = 1; i <= SL.ListLen; i++) {
			System.out.println(SL.ListData[i].key + " " + SL.ListData[i].name + " " + SL.ListData[i].age);
		}
		return 0;
	}
}
public class SearchStructure {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i;
		SLType SL = new SLType();
		Data pdata;
		Scanner input = new Scanner(System.in);
		System.out.print("顺序表操作演示：\n");
		SL.SLInit(SL); 								//初始化
		System.out.println("初始化成功");
		
		do {
			System.out.println("输入添加的结点：学号  姓名  年龄");
			Data data = new Data();
			data.key = input.next();
			data.name = input.next();
			data.age = input.nextInt();
			
			if (data.age > 0) {						//若年龄不为0
				if (SL.SLAdd(SL, data) == 0) {
					break;
				}
			}else{
				break;								//年龄为0，退出死循环
			}
		} while (true);
		
		System.out.println("顺序表中的结点顺序是：");
		
		SL.SLAll(SL);
		
		System.out.print("要取出的结点：");
		i = input.nextInt();
		pdata = SL.SLFindByNum(SL, i);
		if (!pdata.equals(null)) {
			System.out.print("第" + i + "个结点为：" + pdata.key + " " + pdata.name + " " + pdata.age);
		}
	}

}
