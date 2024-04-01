
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		StringTokenizer st;
		StringBuilder sb;
		
		for (int test = 1; test <= 10; test++) {
			
			sb = new StringBuilder();
			sb.append("#"+test);
			st = new StringTokenizer(sc.nextLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());

			int[][] adj = new int[V + 1][V + 1];
			int[] degree = new int[V + 1];

			st = new StringTokenizer(sc.nextLine());
			int a, b;
			for (int i = 0; i < E; i++) {
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				adj[a][b] = 1;

				degree[b]++; // 진입차수 증가
			}

			Queue<Integer> queue = new LinkedList<>();

			for (int i = 1; i < V + 1; i++) {
				if (degree[i] == 0) {
					queue.offer(i);
				}
			}

			// 위상정렬 시작
			while (!queue.isEmpty()) {

				int temp = queue.poll();
				sb.append(" " + temp);
				for (int i = 1; i < V + 1; i++) {
					if (adj[temp][i] == 1) {
						degree[i]--;
						if (degree[i] == 0) {
							queue.offer(i);
						}
					}
				}
			}

			System.out.println(sb.toString());
		}
	}
}
