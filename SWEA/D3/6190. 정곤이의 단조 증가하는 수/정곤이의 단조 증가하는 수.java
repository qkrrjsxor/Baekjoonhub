
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * 완전 탐색으로 해보자
 * 이곳저곳 물어보았지만 완전탐색밖에 없는 것 같다
 * 
 */
public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();

		for (int test = 1; test <= tc; test++) {

			int N = sc.nextInt();
			int[] arr = new int[N];
			List<Integer> result = new ArrayList<>();

			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}

			// 완전탐색
			for (int i = 0; i < N - 1; i++) {
				for (int t = i + 1; t < N; t++) {
					int tmp = arr[i] * arr[t];

					tmp = isIncrease(tmp);

					if (tmp != 0) {
						result.add(isIncrease(tmp));
					}
				}
			}

			int max = -1;
			
			for (int i = 0; i < result.size(); i++) {
				if(result.get(i) > max) {
					max = result.get(i);
				}
			}
			
			System.out.print("#" + test + " ");
			if (result.size() == 0) {
				System.out.println(-1);
			} else {
				System.out.println(max);
			}

		}
	}

	static int isIncrease(int n) {
		int rest = 1;
		int num = n;

		while (num != 0) {

			rest = num % 10;
			num = num / 10;

			if (rest < num % 10) {
				return 0;
			}
		}
		return n;
	}
}