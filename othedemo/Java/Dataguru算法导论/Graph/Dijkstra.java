package Graph;

/*
 *Dijkstra�����·���㷨 
 */

public class Dijkstra {

	public static final int M = -1;
	static int[][] map = {
		{ 0,  7,  9,  M,  M, 14 }, 
        { 7,  0,  10, 15, M, M },
        { 9,  10, 0,  11, M, 2 }, 
        { M,  15, 11, 0,  6, M },
        { M,  M,  M,  6,  0, 9 }, 
        { 14, M,  2,  M,  9, 0 }
	};
	static int n =map.length;       //����ĸ���
	static int[] shortest = new int[n];  //��Ŵ�start�������ڵ�����·��
	static boolean[] visited = new boolean[n]; //��ǵ�ǰ�ö�������·���Ƿ��Ѿ������true��ʾ�Ѿ����
	
	public static void main(String[] args) {
		int orig = 0; //��ʼ��
		//Ѱ�����·��
		int[] shortPath = dijkstra_alg(orig);
		
		if(shortPath == null){
			return;
		}
		
		for(int i=0; i< shortPath.length; i++){
			System.out.println("��" + (orig + 1) + "������" + (i + 1) + "����̾���Ϊ��"+ shortPath[i]);
			}
	}

	private static int[] dijkstra_alg(int orig) {
		// TODO Auto-generated method stub
		// ��ʼ������һ���������
        shortest[orig] = 0;
        visited[orig] = true;
		for(int count = 0; count != n-1; count ++)
		{
			//ѡ��һ�������ʼ���������Ϊ��Ƕ���
			int k = M;
			int min = M;
			for(int i =0; i< n ; i++)//����ÿһ������
			{
				if( !visited[i] && map[orig][i] != M) //����ö���δ������������orig����
				{
					if(min == -1 || min > map[orig][i]) //�ҵ���orig����ĵ�
					{
						min = map[orig][i];
						k = i;
					}
				}
			}
			//��ȷ��ͼ���ɵľ��󲻿��ܳ���K== M�����
			if(k == M)
			{
				System.out.println("the input map matrix is wrong!");
				return null;
			}
			shortest[k] = min;
		    visited[k] = true;
			//��kΪ���ĵ㣬����oirg��δ���ʵ�ľ���
		    for (int i = 0; i < n; i++)
            {
                if (!visited[i] && map[k][i] != M)
                {
                    int callen = min + map[k][i];
                    if (map[orig][i] == M || map[orig][i] > callen)
                    {
                    	map[orig][i] = callen;
                    }
                }
            }
		}
		
		return shortest;
	}
}
