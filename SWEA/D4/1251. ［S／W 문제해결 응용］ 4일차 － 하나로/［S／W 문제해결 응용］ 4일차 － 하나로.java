
import java.util.Arrays;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
	
	static int N; 
	static double E;
	static double[][] adjArr;	//double E와 곱해야 하므로 double 형 배열
	static int[][] loc;	//섬들의 좌표 담을 배열 0번 인덱스 : x좌표
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st;

		int tc = Integer.parseInt(sc.nextLine());

		for (int test = 1; test <= tc; test++) {

			N = Integer.parseInt(sc.nextLine());
			
			adjArr = new double[N][N];
			loc = new int[N][2];
			//x 좌표들 입력받기
			st = new StringTokenizer(sc.nextLine());
			for(int i = 0; i<N; i++) {
				loc[i][0] = Integer.parseInt(st.nextToken());
			}
			//y 좌표들 입력받기
			st = new StringTokenizer(sc.nextLine());
			for(int i = 0; i<N; i++) {
				loc[i][1] = Integer.parseInt(st.nextToken());
			}
			
			E = Double.parseDouble(sc.nextLine());
			
			long x1, x2, y1, y2;
			for(int i = 0; i< N ; i++) {
				for(int t = i+1; t< N; t++) {
					x1 = loc[i][0];
					x2 = loc[t][0];
					y1 = loc[i][1];
					y2 = loc[t][1];
					
					adjArr[i][t] = adjArr[t][i] = ((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2))*E;
				}
			}	
			//여기까지 입력 받고 인접 배열과 가중치(환경부담금) 설정!
			//아래 부터는 프림 알고리즘으로 최소 비용 트리 구해보자
			
			double INF = Double.MAX_VALUE;	//double 최대 값
			boolean[] visited = new boolean[N];
			int[] parent = new int[N];
			double[] dist = new double[N];	//가중치 비용이 double이므로
			
			//dist 배열을 max값으로 초기화
			Arrays.fill(dist, INF);
			
			dist[0] = 0;
			double ans = 0;
			double min;
			int idx;
			//N-1번 탐색
			for(int i = 0 ; i< N-1; i++) {
				min = INF;
				idx = -1;
				// 0번 노드 ~ N-1번 노드에 대해 반복하여
				for(int j = 0; j < N; j++) {
					//방문하지 않았고, 최소 비용인 노드를 찾는다
					if(!visited[j] && dist[j] < min) {
						idx = j;
						min = dist[idx];
					}
				}
				
				visited[idx] = true;
				
				//선택한 노드(방문한 노드) 에 대해서 인접한 친구들 최소값으로 갱신해주기
				for(int j = 0 ; j<N; j++) {
					if(!visited[j] && dist[j] > adjArr[idx][j]) {
						dist[j] = adjArr[idx][j];
						parent[j] = idx;
					}
				}
			}
			
			for(int i = 0 ; i<N; i++) {
				ans += dist[i];
			}
//			Math.round(ans);
			System.out.printf("#%d %.0f%n",test,ans);
		}

	}
}
