
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int test = 0; test < tc; test++) {
			
			int N = sc.nextInt();
			int [] DP = new int [N+1];
			
			DP[1] = 1; // 1
			if (N > 1) {
				DP[2] = 2; // 1 1 / 2

				if (N > 2) {
					DP[3] = 4; // 1 1 1 / 1 2 / 2 1 / 3
				}
			}
			
			//반복을 이용한 재귀
			for(int i= 4; i<= N; i++) {
				DP[i] = DP[i-1] + DP[i-2] + DP[i-3];
			}
			
			System.out.println(DP[N]);
		}
	}
}
