package algorithm;

import java.util.Scanner;

/**
 * 完全二叉树的操作
 * @author lijianfu
 * 2017年11月17日
 * 下午1:58:19
 */
class Tree{											//定义二叉树节点类型
	String data;									//元素数据
	Tree left;										//左子树结点引用
	Tree right;										//右字树结点引用
}
public class TreeType {

	static final int MAXLEN = 20;
	static Scanner input = new Scanner(System.in);
	
	@SuppressWarnings("unused")
	Tree initTree(){								//初始化二叉树的根
		Tree node;
		if ((node = new Tree()) != null) {			//申请内存
			System.out.println("请先输入一个根节点数据");
			node.data = input.next();
			node.left = null;
			node.right = null;
			if (node != null) {						//如果二叉树不为空
				return node;
			}else{
				return null;
			}
		}
		return null;
	}
	
	void addTreeNode(Tree treeNode){				//添加结点
		Tree pnode,parent;
		String data;
		int menuserl;
		
		if ((pnode = new Tree()) != null) {			//分配内存
			System.out.println("输入二叉树结点数据：");
			
			pnode.data = input.next();
			pnode.left = null;						//设置左右结点
			pnode.right = null;
			
			System.out.println("输入该节点的父节点数据：");
			data = input.next();
			
			parent = treeFindNode(treeNode, data);	//查找指定的数据结点
			if (parent == null) {
				System.out.println("未有找到该父节点");
				pnode = null;
				return ;
			}
			System.out.printf("1、添加该节点到左子树\n 2、添加该节点到右字树\n");
			do {
				menuserl = input.nextInt();			//输入选项
				if (menuserl==1 || menuserl==2) {
					System.out.println("不存在父节点，请先设置父节点！");
				}else{
					switch (menuserl) {
					case 1:							//添加到左结点
						if (parent.left != null) {	//左子树不为空
							System.out.println("左子树结点不为空！");
						}else{
							parent.left = pnode;
						}
						break;
						
					case 2:
						if (parent.right != null) {
							System.out.println("右字树结点不为空！");
						}else{
							parent.right = pnode;
						}
						break;

					default:
						System.out.println("无效参数！");
						break;
					}
				}
			} while (menuserl != 1 && menuserl != 2);
		}
	}
	
	Tree treeFindNode(Tree treeNode, String data){	//查找结点
		Tree t;
		if (treeNode == null) {
			return treeNode;
		}else{											//分别向左右字数递归查找
			if ((t=treeFindNode(treeNode.left,data)) != null) {
				return t;
			}else if ((t = treeFindNode(treeNode.right, data)) != null) {
				return t;
			}else{
				return null;
			}
		}
	}
	
	Tree treeLeftNode(Tree treeNode){					//获取左子树
		if (treeNode != null) {
			return treeNode.left;						//返回值
		}else{
			return null;
		}
	}

	Tree treeRightNode(Tree treeNode){					//获取右子树
		if (treeNode != null) {
			return treeNode.right;						//返回值
		}else{
			return null;
		}
	}
	
	int treeIsEmpty(Tree treeNode){					//判断是否为空树
		if (treeNode != null) {
			return 0;
		}else{
			return 1;
		}
	}
	
	int treeDepth(Tree treeNode){						//计算二叉树深度
		int depleft,depright;
		if (treeNode == null) {
			return 0;									//对于空树，深度为0
		}else{
			depleft = treeDepth(treeNode.left);			//左子树深度（通过递归调用）
			depright = treeDepth(treeNode.right);		//右字树深度（通过递归调用）
			
			if (depleft > depright) {
				return depleft + 1;
			}else{
				return depright + 1;
			}
		}
	}
	
	void clearTree(Tree treeNode){					//清空二叉树
		if (treeNode != null) {
			clearTree(treeNode.left);					//清除左子树
			clearTree(treeNode.right);					//清除右字树
			treeNode = null;							//释放当前结点所占内存
		}
	}
	
	void treeNodeData(Tree p){							//显示所有的结点数据
		System.out.println(p.data);
	}
	
	void levelTree(Tree treeNode){					//按层编历
		Tree t;
		Tree q[] = new Tree[MAXLEN];					//定义一个顺序栈
		int head = 0;
		int tail = 0;
		
		if (treeNode != null) {
			tail = (tail+1) % MAXLEN;					//计算循环队列队尾序号
			q[tail] = treeNode;							//将二叉树根引用进队
		}
		while (head != tail) {							//队列不为空，进行循环
			head = (head+1)%MAXLEN;						//计算循环队列的队首序号
			t = q[head];								//获取队首元素
			treeNodeData(t); 							//处理队首元素
			if (t.left != null) {
				tail = (tail+1) % MAXLEN;				//计算循环队尾序号
				q[tail] = t.left;							//将左子树引用进队
			}
			
			if (t.right != null) {						//如果结点存在右字树
				tail = (tail+1) % MAXLEN;				//计算循环队尾序号
				q[tail] = t.right;						//将右子树引用进队
			}
		}	
	}
	
	void DLRTree(Tree treeNode){						//先序遍历
		if (treeNode != null) {
			treeNodeData(treeNode);						//显示结点的数据
			DLRTree(treeNode.left);
			DLRTree(treeNode.right);
		}
	}
	
	void LDRTree(Tree treeNode){						//中序遍历
		if (treeNode != null) {
			LDRTree(treeNode.left);	
			treeNodeData(treeNode);
			LDRTree(treeNode.right);
		}
	}
	
	void LRDTree(Tree treeNode){						//后序遍历
		if (treeNode != null) {
			LRDTree(treeNode.left);
			LRDTree(treeNode.right);
			treeNodeData(treeNode);
		}
	}

	public static void main(String[] args) {
		Tree root = null;
		int menuserl = 0;
		TreeType t = new TreeType();
		//设置根元素
		root = t.initTree();
		//添加结点
		do {
			System.out.println("请选择菜单添加二叉树的结点：");
			System.out.printf("0,退出\t");
			System.out.printf("1,添加二叉树的结点\n");
			menuserl = input.nextInt();
			switch (menuserl) {
			case 1:
				t.addTreeNode(root);
				break;
				
			case 0:
				break;

			default:
				;
			}
		} while (menuserl != 0);
		
		do {
			System.out.println("请选择菜单遍历二叉树，输入0表示退出：");
			System.out.printf("1、先序遍历DLR\t");
			System.out.printf("2、中序遍历LDR\t");
			System.out.printf("3、后序遍历LRD\t");
			System.out.printf("4、按层遍历\n");
			menuserl = input.nextInt();
			switch (menuserl) {
			case 0:
				break;
				
			case 1:
				System.out.println("先序遍历结果：");
				t.DLRTree(root);
				System.out.println();
				break;
				
			case 2:
				System.out.println("中序遍历结果：");
				t.LDRTree(root);
				System.out.println();
				break;
				
			case 3:
				System.out.println("后序遍历结果：");
				t.LRDTree(root);
				System.out.println();
				break;
				
			case 4:
				System.out.println("按层遍历结果：");
				t.levelTree(root);
				System.out.println();
				break;

			default:
				;
			}
		} while (menuserl != 0);
		
		//深度
		System.out.println("二叉树的深度为：" + t.treeDepth(root));
		
		//清空二叉树
		t.clearTree(root); 
		root = null;
	}

}
