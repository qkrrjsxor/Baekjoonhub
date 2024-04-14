
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StringTokenizer st;
		
		st = new StringTokenizer(sc.nextLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		boolean[][] visit = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			String line = sc.nextLine();
			for(int t= 0; t < M; t++) {
				map[i][t] = line.charAt(t) - '1';
			}
		}
		
		
		Queue<int[]> queue = new LinkedList<>();
		
		int[] coordinate = new int[2];
		coordinate[0] = 0;
		coordinate[1] = 0;
		
		queue.offer(coordinate);
		map[0][0] = 1;
		visit[0][0] = true;
		
		while(!queue.isEmpty()) {
			int now[] = queue.poll();
			int r = now[0];
			int c = now[1];
			
			for(int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nr >= 0 && nr < N && nc >=0 && nc < M && map[nr][nc] != -1) {
					if(!visit[nr][nc]) {
						map[nr][nc] = map[r][c] + 1;
						visit[nr][nc] = true;
						
						coordinate = new int[2];
						coordinate[0] = nr;
						coordinate[1] = nc;
						
						queue.offer(coordinate);

					}
				}
			}
		}
		
		System.out.println(map[N-1][M-1]);
	}
}
