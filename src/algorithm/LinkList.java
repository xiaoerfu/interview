package algorithm;

import java.util.Scanner;

import org.omg.CORBA.FREE_MEM;

/**
 * 链表的基本操作
 * @author lijianfu
 * 2017年11月16日
 * 上午10:59:00
 */

class Data2{
	String key;									//结点的关键字0
	String name;
	int age;
}

class CLType{									//定义链表结构
	Data2 nodeData = new Data2();
	CLType nextNode;
	
	/**
	 * 在链表末尾添加结点
	 * @param head
	 * @param nodeData
	 * @return
	 */
	@SuppressWarnings("unused")
	CLType CLAddEnd(CLType head, Data2 nodeData){//尾部追加结点
		CLType node, htemp;
		if ((node = new CLType()) == null) {
			System.out.println("申请内存失败！");		//分配内存失败
			return null;
		}else{
			node.nodeData = nodeData;				//保存数据
			node.nextNode = null;					//设置结点引用为空，即为表尾
			if (head == null) {						//头引用
				head = node;
				return head;
			}
			htemp = head;
			while (htemp.nextNode != null) {		//查找链表的结尾
				htemp = htemp.nextNode;
			}
			htemp.nextNode = node;
			return head;
		}
	}
	
	/**
	 * 在头部添加结点
	 * @param head
	 * @param nodeData
	 * @return
	 */
	@SuppressWarnings("unused")
	CLType CLAddFirst(CLType head, Data2 nodeData){
		CLType node;
		if ((node = new CLType()) == null) {
			System.out.println("申请内存失败！");			//分配内存失败
			return null;
		}else{
			node.nodeData = nodeData;					//保存数据
			node.nextNode = head;						//指向头引用所指结点
			head = node;								//头引用指向新增节点
			return head;
		}
	}
	
	/**
	 * 通过key查找对应的结点内容
	 * @param head
	 * @param key
	 * @return
	 */
	CLType CLFindNode(CLType head, String key){
		CLType htemp;
		htemp = head;									//保存链表头引用
		while (htemp != null) {							//若结点有效，则进行查找
			if (htemp.nodeData.key.compareTo(key) == 0) {	//若结点关键字与传入的key一致
				return htemp;								//返回该节点引用
			}	
			htemp = htemp.nextNode;							//处理下一个结点
		}
		return null;										//返回空引用
	}
	
	/**
	 * 插入结点
	 * @param head
	 * @param findKey
	 * @param nodeData
	 * @return
	 */
	@SuppressWarnings("unused")
	CLType CLInsertNode(CLType head, String findKey, Data2 nodeData){
		CLType node, nodetemp;
		if ((node = new CLType()) == null) {				//分配保存结点的内容
			System.out.println("申请内存失败!");
			return null;									//分配内容失败
		}
		node.nodeData = nodeData;							//保存节点数据
		nodetemp = CLFindNode(head, findKey);
		if (nodetemp != null) {								//若找到插入的结点
			node.nextNode = nodetemp.nextNode;				//新插入结点指向关键节点的下一个结点
			nodetemp.nextNode = node;						//设置关键节点指向新插入节点
		}else{
			System.out.println("未找到正确的插入位置！");
			free(node);										//释放内存
		}
		return head;										//返回头引用
	}
	
	/**
	 * 删除结点
	 * @param head
	 * @param key
	 * @return
	 */
	int CLDeleteNode(CLType head, String key){
		CLType node,htemp;									//node 保存删除节点的前一个结点
		htemp = head;
		node = head;
		while (htemp != null) {
			if (htemp.nodeData.key.compareTo(key) == 0) {	//找到关键字，执行删除操作
				node.nextNode = htemp.nextNode;				//使前一个结点指向当前结点的下一个结点
				free(htemp);								//释放内存
				return 1;
			}else{
				node = htemp;								//指向当前结点
				htemp = htemp.nextNode;						//指向下一个结点
			}
		}
		return 0;
	}

	/**
	 * 计算结点的长度
	 * @param head
	 * @return
	 */
	int CLLength(CLType head){
		CLType htemp;
		int len = 0;
		htemp = head;
		while (htemp != null) {								//遍历整个链表
			len++;											//累加计数
			htemp = htemp.nextNode;							//处理下一个结点
		}
		return len;											//返回结点数
	}
	
	/**
	 * 查询链表全部内容
	 * @param head
	 */
	void CLAllNode(CLType head){
		CLType htemp;
		Data2 nodeData;
		htemp = head;
		System.out.printf("当前链表有%d个结点，链表数据如下：\n",CLLength(head));
		while (htemp != null) {
			nodeData = htemp.nodeData;						//获取结点数据
			System.out.printf("结点（%s,%s,%d）\n",nodeData.key,nodeData.name,nodeData.age);
			htemp = htemp.nextNode;							//处理下一个结点
		}
	}
	private void free(CLType htemp) {
		// TODO Auto-generated method stub
		
	}
}

public class LinkList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CLType node, head = null;
		CLType CL = new CLType();
		String key,findKey;
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		System.out.println("链表测试，先输入链表中的数据，格式为：关键字 姓名 年龄");
		do {
			Data2 nodeData = new Data2();
			nodeData.key = input.next();
			if (nodeData.key.equals("0")) {						//输入0就退出
				break;
			}else{
				nodeData.name = input.next();
				nodeData.age = input.nextInt();
				head = CL.CLAddEnd(head, nodeData);				//在链表尾部添加结点
			}
		} while (true);
		CL.CLAllNode(head);
		
		System.out.println("显示插入结点，输入插入结点的关键字：");
		findKey = input.next();
		System.out.println("输入插入结点的数据（关键字 姓名 年龄）：");
		Data2 nodeData = new Data2();
		nodeData.key = input.next();
		nodeData.name = input.next();
		nodeData.age = input.nextInt();							//输入插入结点的数据
		head = CL.CLInsertNode(head, findKey, nodeData);		//调用插入函数
		CL.CLAllNode(head);										//显示所有结点
		
		System.out.println("演示删除结点，输入要删除的关键字：");
		
		key = input.next();										//输入要删除的结点
		CL.CLDeleteNode(head, key);								//调用删除函数，返回结点引用
		CL.CLAllNode(head);										//显示所有结点
		
		System.out.println("演示在链表中查找，输入查找关键字：");
		
		key = input.next();										//输入查找的关键字
		node = CL.CLFindNode(head, key);						//调用查找函数，返回结点引用
		if (node != null) {										//若查找不为空
			nodeData = node.nodeData;							//获取结点数据
			System.out.printf("关键字%s对应的结点为(%s,%s,%d)\n",key,nodeData.key,
					nodeData.name, nodeData.age);
		}else{													//若为空，则返回空
			System.out.printf("在链表中未找到关键字为%s的结点!\n", key);
		}
	}

}
