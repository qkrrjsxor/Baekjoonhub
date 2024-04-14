
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = { 0, -1, -1 };
	static int[] dc = { 1, 1, 0 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int t = 0; t < M; t++) {
				map[i][t] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] dp = new int[N][M];
		dp[0][0]= map[0][0];
		for(int i =1 ; i < M; i++) {
			dp[0][i] = dp[0][i-1] + map[0][i];
		}
		for(int i =1 ; i < N; i++) {
			dp[i][0] = dp[i-1][0] + map[i][0];
		}
		
		for(int r = 1; r < N; r++) {
			for(int c = 1; c < M; c++) {
				dp[r][c] = Math.max(dp[r-1][c] + map[r][c], dp[r][c-1] + map[r][c]);
			}
		}
		
		System.out.println(dp[N-1][M-1]);
	}
}
