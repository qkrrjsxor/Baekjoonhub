
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
	static int[][] board;
	static int count;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st;

		int tc = Integer.parseInt(sc.nextLine());
		for (int test = 1; test <= tc; test++) {
			String str = sc.nextLine();
			st = new StringTokenizer(str);

			int N = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());
			count = 0;

			board = new int[N][N];

			for (int i = 0; i < N; i++) {
				str = sc.nextLine();
				st = new StringTokenizer(str);
				for (int t = 0; t < N; t++) {
					board[i][t] = Integer.parseInt(st.nextToken());
				}
			}

			for (int r = 0; r < N; r++) {
				go: for (int c = 0; c < N - len + 1; c++) {

					for (int l = 0; l < len; l++) {
						if (board[r][c + l] == 0) {
							continue go;
						}
					}
					if (c + len == N) {
						if(board[r][c-1] == 0) {
							count++;
						}
						continue go;
					}

					if (c == 0) {
						if (board[r][c + len] == 0) {
							count++;
						}
					} else {
						if (board[r][c + len] == 0 && board[r][c - 1] == 0) {
							count++;
						}
					}
				}
			}

			for (int c = 0; c < N; c++) {
				go: for (int r = 0; r < N - len + 1; r++) {

					for (int l = 0; l < len; l++) {
						if (board[r + l][c] == 0) {
							continue go;
						}
					}
					if (r + len == N) {
						if(board[r-1][c] == 0) {
							count++;							
						}
						continue go;
					}

					if (r == 0) {
						if (board[r + len][c] == 0) {
							count++;
						}
					} else {
						if (board[r + len][c] == 0 && board[r - 1][c] == 0) {
							count++;
						}
					}
				}
			}

			System.out.printf("#%d %d%n", test, count);
		}
	}

}
