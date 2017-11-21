package algorithm;

import java.util.Scanner;

class DATA{
	String key;		//定义结点关键字
	String name;
	int age;
}

class SLType{		//定义顺序表的类型
	static final int MAXLEN = 100;		//定义其大小
	DATA[] ListData = new DATA[MAXLEN];		//保存顺序表的结构数组
	int ListLen;							//顺序表已存的数量
	
	void SLInit(SLType SL){
		SL.ListLen = 0;						//初始化顺序表,设置为0,初始化为空表
	}
	
	int SLLength(SLType SL){
		return(SL.ListLen);					//返回顺序表的元素数量
	}
	
	/**
	 * 插入结点
	 * @param SL
	 * @param n
	 * @param data
	 * @return
	 */
	int SLInsert(SLType SL, int n, DATA data){

		if (SL.ListLen >= MAXLEN) {			//超出顺序结点最大数量
			System.out.println("顺序表已满，不能插入结点");
			return 0;						//返回0，表示插入不成功
		}
		if (n<1 || n>SL.ListLen-1) {
			System.out.println("插入结点的序号有误，不能插入结点");
			return 0;
		}
		for (int i = SL.ListLen; i >= n; i--) {//将顺序表向后退
			SL.ListData[i+1] = SL.ListData[i];
		}
		SL.ListData[n] = data;				//插入结点
		SL.ListLen++;						//结点长度+1
		return 1;							//返回1，表示插入成功
	}
	
	/**
	 * 添加结点
	 * @param SL
	 * @param data
	 * @return
	 */
	int SLAdd(SLType SL, DATA data){
		
		if (SL.ListLen >= MAXLEN) {			//超出顺序结点最大数量
			System.out.println("顺序表已满，不能插入结点");
			return 0;						//返回0，表示插入不成功
		}
		SL.ListData[++SL.ListLen] = data;
//		SL.ListLen++;
		return 1;
	}
	
	/**
	 * 删除结点
	 * @param SL
	 * @param n
	 * @return
	 */
	int SLDelete(SLType SL, int n){
		if (n<1 || n>SL.ListLen+1) {		//删除序号不正确
			System.out.println("删除结点序号错误，不能删除结点");
			return 0;
		}
		for (int i = 1; i <= SL.ListLen; i++) {
			SL.ListData[i] = SL.ListData[i+1];
		}
		SL.ListLen--;						//顺序表减一
		return 1;
	}
	
	/**
	 * 根据序号查找顺序表内容
	 * @param SL
	 * @param n
	 * @return
	 */
	DATA SLFindByNum(SLType SL, int n){
		if (n<1 || n>SL.ListLen+1) {
			System.out.println("结点序号错误，不能返回此节点");
			return null;					//不成功返回null
		}
		return SL.ListData[n];
	}
	
	/**
	 * 按照关键字查找节点
	 * @param SL
	 * @param key
	 * @return
	 */
	int SLFindByCont(SLType SL, String key){
		for (int i = 1; i <= SL.ListLen; i++) {
			if (SL.ListData[i].key.compareTo(key) == 0) {	//如果找到所需的结点
				return i;									//返回结点
			}
		}
		return 0;	
	}
	
	/**
	 * 显示顺序表所有的内容
	 * @param SL
	 * @return
	 */
	int SLAll(SLType SL){
		for (int i = 1; i <= SL.ListLen; i++) {
			System.err.printf("(%s,%s,%d)\n",SL.ListData[i].key,SL.ListData[i].name,SL.ListData[i].age);
		}
		return 0;											//查找不到顺序表内容，返回零
	}
}
public class SequenceList {

	public static void main(String[] args) {
		
		
		SLType SL = new SLType();							//定义顺序表变量
		DATA data;
		String key;
		int i;
		System.out.println("顺序表操作演示：");
		
		//1、初始化
		SL.SLInit(SL);
		System.out.println("初始化顺序表成功");
		//2、获取键盘输入的值
		Scanner input = new Scanner(System.in);
		do {
			System.out.print("输入添加的结点：");
			DATA data1 = new DATA();
			data1.key = input.next();
			data1.name = input.next();
			data1.age = input.nextInt();
			
			if (data1.age != 0) {
				if (SL.SLAdd(SL, data1) == 0) {
					break;
				}
			}else{
				break;							//若年龄为0，退出死循环
			}
		} while (true);
		System.out.println("显示出所有顺序表内容");
		SL.SLAll(SL);
		
		System.out.println("输入要取出的结点序号：");
		i = input.nextInt();
		data = SL.SLFindByNum(SL, i);
		if (data != null) {
			System.out.printf("第%d个结点为：(%s,%s,%d)",i, data.key, data.name, data.age);
		}
		System.out.println("查找结点的关键字：");
		key = input.next();						//输入关键字
		i = SL.SLFindByCont(SL, key);		//按照关键字查找，返回结点序号
		data = SL.SLFindByNum(SL, i);			//按序号查询返回结点引用
		if (data != null) {
			System.out.printf("第%d个结点为：(%s,%s,%d)",i, data.key, data.name, data.age);
		}
	}

}
