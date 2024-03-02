
import java.util.Scanner;

/*
 * 입력받은 길이만큼 배열을 만들자.
 * 각 인덱스의 값은 는 인덱스에 해당하는 사람수 만큼 기립박수를 치면 기립박수를 치는 사람들
 * 
 * -> 누적합 배열을 만들어서 인덱스 + 1 만큼 해당 인덱스에 값이 있어야 한다.
 * 
 */
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = Integer.parseInt(sc.nextLine());
		for (int test = 1; test <= tc; test++) {

			String str = sc.nextLine();
			int len = str.length();
			int[] arr = new int[len];

			// 누적합 배열
			arr[0] = str.charAt(0) - '0';
			for (int i = 1; i < len; i++) {
				arr[i] = arr[i - 1] + str.charAt(i) - '0';
			}

			int min = 0;
			for (int i = 0; i < len; i++) {

				int result = arr[i] - (i + 1);

				if (result < min) {
					min = result;
				}

			}
//			if(min ==0) {
//				System.out.printf("#%d %d%n", test, Math.abs(min));
//			}
			System.out.printf("#%d %d%n", test, Math.abs(min));
		}
	}
}
