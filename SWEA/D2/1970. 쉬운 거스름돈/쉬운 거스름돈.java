
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb;
		int tc = sc.nextInt();
		
		for(int test = 1; test <= tc; test++) {
			
			sb = new StringBuilder();
			
			sb.append("#").append(test).append("\n");
			
			int money = sc.nextInt();
			int[] count = new int[] {50000, 10000, 5000, 1000, 500, 100, 50, 10};
			
			for(int i = 0; i < 8; i++) {
				int N = money/count[i];
				money = money - N*count[i];
				sb.append(N + " ");
//				System.out.println(N);
			}
//			sb.append("\n");
//			
//			System.out.println("#"+test);
//			for(int i = 7 ; i>=0; i--) {
//				System.out.print(count[i] + " ");
//			}
			System.out.println(sb.toString());
		}
	}
}
