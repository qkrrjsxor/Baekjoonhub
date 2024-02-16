
import java.util.Scanner;

/*
 * 쌀 때 사서 비쌀 떄 판다!
 * 
 * 1. 최대 가격이 마지막날 인 경우
 * 	-> 매일매일 사서 마지막날에 판다
 * 
 * 2. 최대 가격이 중간에 있는 경우 (마지막날이 최대가 아닌 경우)
 * 	2-1. 중간의 최대가격 이후에 또 가격이 오르다가 떨어지는 날이 있는 경우
 * 		-> 여기서 막혀서 .. 주변에서 힌트를 얻어서 뒤에서부터 탐색하는것으로 변경
 *  2-2. 중간 최대 가격 이후에 계속 우하향 하는 경우
 *		-> 중간의 최대 가격 날 까지 사다가 판것이 최종 이득
 *
 *
 */
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();

		for (int test = 1; test <= tc; test++) {

			int max = -1;
			int maxIdx = 0;

			int day = sc.nextInt();
			int[] price = new int[day];
			long sum = 0;

			for (int i = 0; i < day; i++) {
				price[i] = sc.nextInt();

			}

			maxIdx = day-1;
			
			for(int i = day-1; i>=0; i--) {
				if(price[maxIdx] >= price[i]) {
					sum += price[maxIdx] - price[i];
				}else if(price[maxIdx] < price[i]) {
					maxIdx = i;
				}
			}
			
			System.out.printf("#%d %d%n", test, sum);

		}
	}

}
