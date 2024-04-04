
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {

	static int N, B;
	static int[] heights;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st;

		int tc = Integer.parseInt(sc.nextLine());

		for (int test = 1; test <= tc; test++) {
			sum = 0;
			ans = 987654321;
			st = new StringTokenizer(sc.nextLine());
			N = Integer.parseInt(st.nextToken()); // 직원의 수
			B = Integer.parseInt(st.nextToken()); // 선반의 높이

			st = new StringTokenizer(sc.nextLine());
			heights = new int[(int) N];

			for (int i = 0; i < N; i++) {
				heights[i] = Integer.parseInt(st.nextToken());
			} // 직원들 키 입력

			visited = new boolean[(int) N];
			backtracking(0,0);
			
			System.out.println("#"+test+ " " + (ans - B));
		}

	}

	static int sum;
	static int ans;
	static int[] abc;
	public static void backtracking(int idx, int selidx) {
		// base
		if (sum >= B) {
			if (sum < ans) {
				ans = sum;
			}
			return;
		}
		if(idx >= N) {
			return;
		}

		// recursive
		sum+=heights[idx];
		backtracking(idx+1, selidx+1);
		sum-= heights[idx];
		
		backtracking(idx+1, selidx);

	}
}