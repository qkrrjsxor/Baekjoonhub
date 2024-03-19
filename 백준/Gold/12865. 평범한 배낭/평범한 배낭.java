

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String str;
		
		str = br.readLine();
		st = new StringTokenizer(str);
		
		int N = Integer.parseInt(st.nextToken());
		int limit = Integer.parseInt(st.nextToken());
		
		int[][] dp = new int[N+1][limit+1];
		int[] weight = new int[N+1];
		int[] value = new int[N+1];
		
		for(int i = 1; i<= N; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			weight[i] = Integer.parseInt(st.nextToken());
			value[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 1; i<= N; i++) {
			for(int j = 1; j<= limit; j++) {
				
				// 
				if(weight[i] > j) {
					dp[i][j] = dp[i-1][j];
				}
				else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i]]+value[i]);
				}
				
			}
		}
		
		System.out.println(dp[N][limit]);
	}
}
