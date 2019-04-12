package Graph;

import java.util.ArrayList;
import java.util.List;

/*
 * ������ȱ����㷨
 * DFS
 */
public class DFS {

	private static Object[] vet; //����vet����������Ŷ�����Ϣ
	private static int[][] array;  //�����ڽӾ����������ͼ�Ķ�����Ϣ
	private static int vexnum;      //��űߵ�����
	private static boolean[] ifvisited; //��Žڵ��Ƿ񱻷��ʹ�
	private static List<Object> list = new ArrayList<Object>();  //����һ����ʱ�Ķ�����������Ѿ������ʹ��Ľڵ�

	public static void main(String[] args) {
		DFS map = new DFS(5); //��ʼ������
		Character[] vet = {'A','B','C','D','E'};
		map.addVet(vet);   //��Ӷ���
		map.addEage(0,1);
		map.addEage(0,4);
		map.addEage(1,3);
		map.addEage(2,3);
		map.addEage(2,4);
		
		System.out.println("������ȱ�����ʼ...");
		visited(0);
		ifvisited[0]=true;
		map.dfs(0);
	}
	
	//������ȱ���
	private void dfs(int k) {
		// TODO Auto-generated method stub
		for(int i=0; i< vexnum; i++)
			if(array[k][i] == 1 && !ifvisited[i])//�ж��Ƿ񱻷��ʹ�������ֵ�Ƿ�Ϊ1
			{
				ifvisited[i] = true;
				visited(i);   //��ӵ������ʹ��Ľڵ����
				for(int j=0; j<vexnum; j++)
				{
					if(!ifvisited[j] && array[i][j] ==1)
					{
						ifvisited[j] = true;
						visited(j);
						dfs(j);  //�´�ѭ����vet[j]��ʼѭ��
					}
				}
			}
	}

	//����ʱ����������Ѿ����ʹ��Ľ�㣬�����
	private static void visited(int k) {
		// TODO Auto-generated method stub
		list.add(vet[k]);
		System.out.println("   -> " + vet[k]);
	}

	//�����ڽӾ��󣬱���ߵ���Ϣ
	private void addEage(int m, int n) {
		// TODO Auto-generated method stub
		if(m!=n){
			array[m][n] =1;
			array[n][m] =1;
		}
		else
			return;
	}
	
	//��ʼ��ͼ�Ķ���
	private void addVet(Character[] vet2) {
		// TODO Auto-generated method stub
		this.vet = vet2;
	}

	//ͼ�ĳ�ʼ��
	public DFS(int num) {
		// TODO Auto-generated constructor stub
		vexnum = num;   //����
		vet = new Object[num]; //�������Ϣ
		array = new int[num][num];  //�ߵ���Ϣ
		ifvisited = new boolean[num]; //�Ƿ񱻷��ʹ�
		for(int i =0 ;i< num; i++)    //��ʼ����
		{
			ifvisited[i] = false;
			for(int j =0;j<num;j++)
				array[i][j]=0;
		}
	}


}
