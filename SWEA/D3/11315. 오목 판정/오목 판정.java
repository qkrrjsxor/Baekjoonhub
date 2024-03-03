
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = Integer.parseInt(sc.nextLine());

		int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
		int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };

		test : for (int test = 1; test <= tc; test++) {

			int N = Integer.parseInt(sc.nextLine());

			char[][] board = new char[N][N];

			String str;
			for (int i = 0; i < N; i++) {
				str = sc.nextLine();
				board[i] = str.toCharArray();
			}

			int dir = 0;
			int nr = 0;
			int nc = 0;

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					
					dir = 0;
					
					direction: for (; dir < 8; dir++) {
						nr = r;
						nc = c;
//						System.out.println("nr : " + nr + ", nc : " + nc + ", dir: " + dir);
						for (int i = 0; i < 5; i++) {
							
							if (nr < 0 || nr >= N || nc < 0 || nc >= N || board[nr][nc] == '.') {
								continue direction;
							}
//							System.out.println("nr : " + nr + ", nc : " + nc);
							nr=nr+dr[dir];
							nc=nc+dc[dir];
						}
						System.out.println("#"+test+" YES");
						continue test;

					}
//					System.out.println("asdasd");
				}
			}
			System.out.println("#"+test+" NO");
		}
	}
}
