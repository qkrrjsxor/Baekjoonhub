
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
	
	static int N;
	static int L;
	static int[] score;
	static int[] cal;
	static int scoretemp;
	static int caltemp;
	static StringTokenizer st;
	static String str;
	static int[] sel;
	static List<Integer> sum;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int tc = Integer.parseInt(sc.nextLine());
		
		for(int test = 1; test <= tc; test++) {
			
			int max = -1;
			
			str = sc.nextLine();
			st = new StringTokenizer(str);
			
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			score = new int[N];
			cal = new int[N];
			sel = new int[N];
			sum = new ArrayList<>();
			
			for(int i =0; i<N; i++) {
				str = sc.nextLine();
				st = new StringTokenizer(str);
				
				score[i] = Integer.parseInt(st.nextToken());
				cal[i] = Integer.parseInt(st.nextToken());
			}
			
//			System.out.println(Arrays.toString(score));
//			System.out.println(Arrays.toString(cal));
			
			sumScore();
			
//			System.out.println("method 끝");
			
			for(int i = 0; i < sum.size(); i++) {
				if(max < sum.get(i)) {
					max = sum.get(i);
				}
			}
			
			System.out.printf("#%d %d%n",test, max);
		}
		
	}
	
	public static void sumScore() {
		
//		System.out.println("method 시작"); 
		for(int i =0 ; i < (1<<N); i++) {
			
			caltemp = 0;
			scoretemp = 0;
			
			for(int j = 0; j < N; j++) {
				
				if( (i&(1<<j)) > 0) {
					scoretemp += score[j];
					caltemp += cal[j];
				}
			}
//			System.out.println(caltemp);
//			System.out.println(scoretemp);
			if(caltemp <= L) {
				sum.add(scoretemp);
//				System.out.println(caltemp);
				
			}
			
		}
	}
}
