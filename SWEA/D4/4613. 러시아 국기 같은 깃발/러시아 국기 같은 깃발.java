
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
 * 중간에 파란색 줄을 기준으로 몇행 부터 몇행 까지 파란 줄일지 케이스를 따져가면서 찾아보자..
 * 깃발의 총 행이 N 일때,
 * 파란줄의 두께가 1 부터 N-2 까지
 * 	-> 파란색이 1행 부터 N-2행 까지
 * 하나하나 찾아봅시다
 * 
 */
public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int tc = sc.nextInt();
		
		for(int test=  1; test <= tc; test++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			char[][] flag = new char[N][M];
			List<Integer> count = new ArrayList<>();
			
			for(int i = 0; i < N ; i++) {
				
				String str = sc.next();

				flag[i] = str.toCharArray();

			}
			
			//파란색 줄의 두께가 1부터 N-2 까지
			for(int width = 1; width <= N-2; width++) {
				
				//파란 줄의 시작 위치가 1행 ~ (N-1 - 두께) 행 까지
				for(int row = 1; row <= N-1-width; row++) {
					
					int paint = 0;
					
					//맨위의 하얀줄을 칠하는 경우
					for(int white = 0; white < row; white++) {
						
						for(int col = 0; col<M; col++) {
							if(flag[white][col] != 'W') {
								paint++;
							}
						}
					}
					
					//중간의 파란줄을 칠하는 경우
					for(int blue = row; blue < row+width; blue++) {
						
						for(int col = 0; col<M; col++) {
							if(flag[blue][col] != 'B') {
								paint++;
							}
						}
					}
					
					//마지막 빨간 줄을 칠하는 경우
					for(int red = row+width; red < N; red++) {
						
						for(int col = 0; col<M; col++) {
							if(flag[red][col] != 'R') {
								paint++;
							}
						}
					}
					
					count.add(paint);
					
				}
			}
			
			int min = Integer.MAX_VALUE;
			//최소값 찾기
			for(int i = 0; i< count.size(); i++) {
				if(count.get(i) < min) {
					min = count.get(i);
				}
			}
			
			System.out.printf("#%d %d%n",test,min );
		
		}
	}
}
