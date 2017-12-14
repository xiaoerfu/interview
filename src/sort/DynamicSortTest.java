package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * d动态链表的创建和动态数组的排序
 * @author lijianfu
 * 2017年11月27日
 * 上午10:54:57
 */

class LinkList{									//链表结构
	char data;									//数据域
	LinkList next;								//指针域
}

public class DynamicSortTest {

	static Scanner input = new Scanner(System.in);
	static char chc;
	
	private static LinkList CreateLinkList(){		//创建链表
		char ch;
		LinkList list = null;
		
		list = new LinkList();
		list.data = chc;
		list.next = null;
		return list;
	}
	
	static void insertList(LinkList list,char e){		//插入结点
		LinkList p;
		p = new LinkList();
		p.data = e;
		if (list == null) {
			list = p;
			p.next = null;
		}else{
			p.next = list.next;
			list.next = p;
		}
	}
	
	static void DynamicSort(LinkList q){				//动态数组排序
		LinkList p = q;
		int k = 0;
		char t;
		while (p != null) {
			k++;
			p = p.next;
		}
		p = q;
		for (int i = 0; i < k-1; i++) {
			for (int j = 0; j < k-i-1; j++) {
				if (p.data > p.next.data) {
					t = p.data;
					p.data = p.next.data;
					p.next.data = t;
				}
				p = p.next;
			}
			p = q;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int ch;
		LinkList list, q;								//声明链表
		
		System.out.println("动态数组排序：");
		System.out.println("请输入一组字符，以0为结束！");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		ch = (char)reader.read();						//输入链表的第一个数据
		chc = (char)ch;
		q = list = CreateLinkList();					//创建一个链表节点
		while (ch != '0') {
			ch = reader.read();
			if (ch != '0') {
				insertList(q, (char)ch);
				q = q.next;
			}
			
		}
		
		DynamicSort(list);								//动态数组排序
		System.out.println("对该数组排序后的结果是：");
		while (list != null) {
			System.out.print(list.data + " ");
			list = list.next;
		}
		System.out.println();
	}

}
