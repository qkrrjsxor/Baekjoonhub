
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st;

		int tc = Integer.parseInt(sc.nextLine());

		for (int test = 1; test <= tc; test++) {
			String str = sc.nextLine();
			st = new StringTokenizer(str);
			int N = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());

			int[] city = new int[N];

			str = sc.nextLine();
			st = new StringTokenizer(str);

			for (int i = 0; i < N; i++) {
				city[i] = Integer.parseInt(st.nextToken());
			}

			int count = 0;
			int idx = 0;
			loop: for (int i = 0; i <= N - D;) {
				for (int t = 0; t < D; t++) {

					idx = i + t;

					if (city[idx] == 1) {
						i = idx + 1;
						continue loop;
					}
				}
				i = idx + 1;
				count++;
			}

			System.out.printf("#%d %d%n", test, count);
		}
	}
}
