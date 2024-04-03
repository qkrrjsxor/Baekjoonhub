

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static int first;
	static int sum;
	static int N;
	static int ans = Integer.MAX_VALUE;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		arr = new int[N][3];
		dp = new int[N][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int t = 0; t < 3; t++) {
				arr[i][t] = Integer.parseInt(st.nextToken());
			}
		}
		int first;
		
		
		for(int colIdx = 0; colIdx < 3; colIdx++) {
			
			for(int i =0 ; i < N ; i++) {
				for(int t= 0 ; t < 3; t++) {
					dp[i][t] = 987654321;
				}
			}
			
			int[] idx = new int[3];
			
			// 1. 첫행 열을 선택
			dp[0][colIdx] = arr[0][colIdx];
			first = colIdx;
			for(int i = 1; i < N-1; i++) {
				for(int t= 0 ; t<3; t++) {
					if(dp[i-1][(t+1)%3] > dp[i-1][(t+2)%3]) {
						idx[t] = (t+2)%3;
					}else {
						idx[t] = (t+1)%3;
					}
					dp[i][t] = dp[i-1][idx[t]] + arr[i][t];
				}
				
//				for(int k = 0 ; k < N ; k++) {
//					System.out.println(Arrays.toString(dp[k]));
//				}
//				System.out.println();
			}
			
			for(int i = 0; i < 3; i++) {
				if(i == first || i == idx[i]) {
					continue;
				}else {
					if(dp[N-2][(i+1)%3] > dp[N-2][(i+2)%3]) {
						idx[i] = (i+2)%3;
					}else {
						idx[i] = (i+1)%3;
					}
					dp[N-1][i] = dp[N-2][idx[i]] + arr[N-1][i];
				}
				
//				for(int k = 0 ; k < N ; k++) {
//					System.out.println(Arrays.toString(dp[k]));
//				}
//				System.out.println();
				
				if(dp[N-1][i] < ans) {
					ans = dp[N-1][i];
				}
			}
			
			
			
		}
		
		System.out.println(ans);
		
		
	}
}
