

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int[][] visited; // visited를 처음에 0으로 해놓고 방문하면 +1
	static int N;
	static int[] dr = { -1, -1, -1 };
	static int[] dc = { 0, 1, -1 };
	static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		visited = new int[N][N];

		for (int r = 0; r < N; r++) {
			backtracking(0, r);
		}

		System.out.println(count);
	}

	public static void backtracking(int r, int c) {


		// 같은 열에 퀸이 있으면 리턴
		for (int row = 0; row < r; row++) {
			if (visited[row][c] == 1) {
				return;
			}
		}

		int nr = r;
		int nc = c;
		// 왼쪽 대각선에 퀸이 있으면 리턴
		while (true) {
			nr = nr - 1;
			nc = nc - 1;
			if (nr < 0 || nc < 0) {
				break;
			}
			if (visited[nr][nc] == 1) {
				return;
			}
		}

		
		nr = r;
		nc = c;
		//오른쪽 대각선에 퀸이 있으면 리턴
		while (true) {
			nr = nr - 1;
			nc = nc + 1;
			if (nr < 0 || nc >= N) {
				break;
			}
			if (visited[nr][nc] == 1) {
				return;
			}
		}


		//경로에 퀸이 없고 r이 마지막 행 까지 왔으면 카운트 +1 후 리턴
		if (r == N - 1) {
			count++;
			return;
		}
				
		visited[r][c] = 1;

		for (int i = 0; i < N; i++) {
//			System.out.println("backtracking go" +r + i);
			backtracking(r + 1, i);
		}
		
		visited[r][c] = 0;
	}
}
