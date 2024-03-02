
import java.util.Arrays;
import java.util.Scanner;

/*
 * N명의 사람이 있고, 몇 초에 오는지 입력으로 주어진다.
 * M초 동안 K개의 붕어빵을 만든다. (1 ≤ N, M, K ≤ 100)
 * 사람이 도착하는 시간 : 0이상 11,111이하
 * 
 * 1. M초 전에 사람이 오면 Impossible
 * 2. 0초 ~ t*M 초 동안 : t*K개의 붕어빵 만들 수 있다.
 * -> t*M 초 동안 t*K 명 초과의 사람이 오면 Impossible
 * 
 * 설계:
 * 1. t*M 초 동안 t*K 명 초과의 사람이 오면 Impossible
 * 2. 사람이 오는 시간 입력을 받아서 배열에 저장
 * 3. 가장 늦게 오는 사람의 시간을 t라고 가정, 0부터 t까지 M을 단위로 나눈다
 * 4. 각 구간에서 만든 빵보다 많은 사람이 오면 Impossible
 */
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int test = 1; test<=tc; test++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();
			int last = 0;
			
			int[] timetable = new int[N];
			
			for(int i = 0; i< N ; i++) {
				timetable[i] = sc.nextInt();
				
				if(timetable[i] > last)	
					last = timetable[i]; 	//가장 마지막으로 오는 사람의 시간 구하기
			}
			
			
			int breadNum =0;
			int count = 0;
			
			//마지막 시간을 구간별로 나누고 각 구간에서 만든 빵보다 사람이 많은지 누적으로 확인하기
			for(int t = 0; t <= last/M; t++) {
				breadNum = t*K;
				count = 0;
				
				//해당 구간에 온 사람들 수 구하기
				for(int i = 0; i < N; i++) {
					if(timetable[i] < (t+1)*M) {
						count++;
					}
				}

				if(count > breadNum) {
					
					break;
				}
			}
			
			if(count > breadNum) {
				System.out.printf("#%d Impossible%n",test);
			}
			else{
				System.out.printf("#%d Possible%n", test);
			}

		}
	}
}
