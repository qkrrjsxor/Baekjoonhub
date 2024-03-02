
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st;
		
		int tc = Integer.parseInt(sc.nextLine());
		
		for(int test = 1; test <= tc; test++) {
			
			String str;
			int N = Integer.parseInt(sc.nextLine());
			
//			int[][] arr = new int[N][N];
			int[][] arr90 = new int[N][N];
			int[][] arr180 = new int[N][N];
			int[][] arr270 = new int[N][N];
			int temp = 0;
			
			for(int i = 0; i<N; i++) {
				str = sc.nextLine();
				st = new StringTokenizer(str);
				for(int t = 0; t<N; t++) {
					temp = Integer.parseInt(st.nextToken());
					
					arr90[t][N-1-i] = temp;
					arr180[N-1-i][N-1-t] = temp;
					arr270[N-1-t][i] = temp;
				}
			}
			
			System.out.println("#"+test);
			
			for(int i = 0; i< N; i++) {
				
				for(int t = 0; t<N; t++) {
					System.out.print(arr90[i][t]);
				}
				System.out.print(" ");
				for(int t = 0; t<N; t++) {
					System.out.print(arr180[i][t]);
				}
				System.out.print(" ");
				for(int t = 0; t<N; t++) {
					System.out.print(arr270[i][t]);
				}
				System.out.println();
			}
		}
	}
}
