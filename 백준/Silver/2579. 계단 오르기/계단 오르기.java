import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[] dp;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();	//계단 수
		
		int[] stair = new int[N+1];
		dp = new int[N+1];
//		int[] dp1 = new int[N+1];
//		int[] dp2 = new int[N+1];
		
		for(int i = 1; i <= N; i++) {
			stair[i] = sc.nextInt();
		}
		
		dp[1] = stair[1];
		
		if(N >=2 ) {
			dp[2] = stair[1] + stair[2];
			
			for(int i = 3; i < N+1; i++) {
				dp[i] = Math.max(dp[i-2] + stair[i], dp[i-3] + stair[i-1] + stair[i]);
			}
		}
		
		System.out.println(dp[N]);

	}
	

}