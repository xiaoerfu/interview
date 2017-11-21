package algorithm;

import java.util.Scanner;

/**
 * 图结构的算法例子
 * @author lijianfu
 * 2017年11月20日
 * 上午10:18:28
 */
class GraphMatrix{
	static final int MaxNum = 20;
	static final int MaxValue = 65535;
	char[] Vertext = new char[MaxNum];					//保存顶点信息
	int GType;											//图的类型（0：无向图， 1、有向图）
	int VertexNum;										//顶点数量
	int EdgeNum;										//边的数量
	int[][] EdgeWeight = new int[MaxNum][MaxNum];		//保存边的权
	int[] isTrav = new int[MaxNum];					//遍历标志
}

public class GraphTest {
	
	static Scanner input = new Scanner(System.in);		//static修饰，全局变量只初始化一次，防止其他文件单元引用
	
	static void CreateGraph(GraphMatrix GM){			//创建邻接矩阵图
		 int weight;									//权
		 char EstartV,EendV;							//边的起始顶点
		 int i, j, k;
		 
		 System.out.println("输入图中各项顶点信息");
		 for (i = 0; i < GM.VertexNum; i++) {
			System.out.printf("第%d个顶点：", i+1);
			GM.Vertext[i] = (input.next().toCharArray())[0];	//保存到各顶点数组元素中
		}
		 System.out.println("输入构成各边的顶点及权值：");
		 for (k = 0; k < GM.EdgeNum; k++) {
			System.out.printf("第%d条边：", k+1);	
			EstartV = input.next().charAt(0);
			EendV = input.next().charAt(0);
			weight = input.nextInt();
			for (i = 0; EstartV != GM.Vertext[i]; i++);		//在已有顶点中查找开始点
			for (j = 0; EstartV != GM.Vertext[j]; j++);		//在已有顶点中查找终结点
			if (GM.GType == 0) {
				GM.EdgeWeight[j][i] = weight;				//在对角位置保存权值
			}
		}
	}
	
	static void ClearGraph(GraphMatrix GM){				//清除矩阵
		int i,j;
		
		for (i = 0; i < GM.VertexNum; i++) {
			for (j = 0; j < GM.VertexNum; j++) {
				GM.EdgeWeight[i][j] = GraphMatrix.MaxValue;	//设置矩阵中各元素的值为MaxValue
			}
		}
	}
	
	static void OutGraph(GraphMatrix GM){					//输出邻接矩阵
		int i,j;
		for (j = 0; j < GM.VertexNum; j++) {
			System.out.printf("\t%c", GM.Vertext[j]);		//在第一行输出顶点信息
		}
		System.out.println();
		for (i = 0; i < GM.VertexNum; i++) {
			System.out.printf("%c", GM.Vertext[i]);
			for (j = 0;  j< GM.VertexNum; j++) {
				if (GM.EdgeWeight[i][j] == GraphMatrix.MaxValue) {	//若权值为最大值
					System.out.printf("\tZ");						//以Z表示无穷大
				}else{
					System.out.printf("\t%d", GM.EdgeWeight[i][j]);	//输出边的权值
				}
			}
			System.out.println();
		}
	}
	
	static void DeepTraOne(GraphMatrix GM, int n){				//从第n个结点开始，深度遍历图
		int i;
		GM.isTrav[n] = 1;											//标记该节点已处理过
		System.out.printf("->%c", GM.Vertext[n]);					//输出结点信息
		
		//添加处理结点的操作
		for (i = 0; i < GM.VertexNum; i++) {
			if (GM.EdgeWeight[n][i] != GraphMatrix.MaxValue && GM.isTrav[n] == 0 ) {
				DeepTraOne(GM, i); 									//递归进行遍历
			}
		}
	}
	
	static void DeepTraGraph(GraphMatrix GM){						//深度优先遍历
		int i;
		
		for (i = 0; i < GM.VertexNum; i++) {						//清除各顶点遍历标志
			GM.isTrav[i] = 0;
		}
		System.out.println("深度优先遍历结点:");
		for (i = 0; i < GM.VertexNum; i++) {
			if (GM.isTrav[i] == 0) {								//改结点未遍历
				DeepTraOne(GM, i);									//调用函数遍历
			}
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GraphMatrix GM = new GraphMatrix();
		
		System.out.println("输入生成图的类型：");
		GM.GType = input.nextInt();
		System.out.println("输入图的顶点数量：");
		GM.VertexNum = input.nextInt();
		System.out.println("输入图的边数:");
		GM.EdgeNum = input.nextInt();
		ClearGraph(GM);
		CreateGraph(GM);
		System.out.println("该图的邻接矩阵数据如下：");
		OutGraph(GM);											//输出邻接矩阵
		DeepTraGraph(GM);										//深度优先搜索便利图
	}

}
