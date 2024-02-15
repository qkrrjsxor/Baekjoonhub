

import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st;
		
		int tc = Integer.parseInt(sc.nextLine());
		
		for(int test = 1; test <= tc; test++) {
			
			int count = 0;
			int size = Integer.parseInt(sc.nextLine());
			int half = size/2;
			char[] arr = new char[size];
			
			
			for(int i = 0; i <= half ; i++) {
				
				String str = sc.nextLine();
				
				arr = str.toCharArray();
				
				count = count + (arr[half] - '0');
				
				
				for(int t = 1; t <= i; t++) {
					count = count + (arr[half + t] - '0');
					count = count + (arr[half - t] - '0');
					
				}
//				System.out.println(count);
			}
			int tmp = half;
			for(int i = half+1; i <size; i++) {
			
				
				String str = sc.nextLine();
				
				arr = str.toCharArray();
				
				count = count + (arr[half] - '0');
				
				for(int t = 1; t <= tmp-1; t++) {
					count = count + (arr[half + t] - '0');
					count = count + (arr[half - t] - '0');
					
				}
				tmp--;
//				System.out.println(count);
			}
			
			System.out.print("#" + test);
			System.out.println(" " + count);
			
			
		}
	}
}
