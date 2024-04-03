import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] arr;
	static int[][] dp;
	static int sum;
	static int ans;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][3];
		dp = new int[N][3];
		
		for(int i =0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int t = 0 ; t < 3; t++) {
				arr[i][t] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[0][0] = arr[0][0];
		dp[0][1] = arr[0][1];
		dp[0][2] = arr[0][2];
		
		for(int i = 1; i < N; i++) {
			
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + arr[i][0];
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + arr[i][1];
			dp[i][2] = Math.min(dp[i-1][1], dp[i-1][0]) + arr[i][2];
		}
		
		sum = Math.min(dp[N-1][0], dp[N-1][1]);
		ans = Math.min(sum, dp[N-1][2]);
		
		System.out.println(ans);
		
	}
	
	
}
