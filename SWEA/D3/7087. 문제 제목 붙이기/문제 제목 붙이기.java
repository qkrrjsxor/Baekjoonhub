
import java.util.Scanner;

/*
 * 각 문제의 앞글자를 따서 아스키코드로 만들고 카운팅 배열에 넣는다
 * 배열에 0이 나올떄까지 세면 사용할 수 있는 제목의 수!
 */
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = Integer.parseInt(sc.nextLine());

		for (int test = 1; test <= tc; test++) {

			int N = Integer.parseInt(sc.nextLine());
			int[] alphabet = new int[26]; // 카운팅 배열
			int idx = 0;

			String str;

			for (int i = 0; i < N; i++) {
				str = sc.nextLine();
				idx = str.charAt(0) - 'A';	//카운팅 배열의 인덱스 A : 0 ~ Z : 25

				alphabet[idx]++;
			}
			
			int count = 0;
			for (; count < 26; count++) {

				if (alphabet[count] == 0) {
					break;
				}
			}

			System.out.printf("#%d %d%n", test, count);
		}
	}

}
