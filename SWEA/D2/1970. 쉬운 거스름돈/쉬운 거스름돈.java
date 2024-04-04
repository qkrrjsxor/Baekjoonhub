

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int test = 1; test <= tc; test++) {
			
			int money = sc.nextInt()/10;
			int[] count = new int[8];
			
			while(money != 0) {
				if(money >=5000) {
					money -= 5000;
					count[7]++;
					continue;
				}
				if(money >= 1000) {
					money -= 1000;
					count[6]++;
					continue;
				}
				if(money >= 500) {
					money -= 500;
					count[5]++;
					continue;
				}
				if(money >= 100) {
					money -= 100;
					count[4]++;
					continue;
				}
				if(money >= 50) {
					money -= 50;
					count[3]++;
					continue;
				}
				if(money >= 10) {
					money -= 10;
					count[2]++;
					continue;
				}
				if(money >= 5) {
					money -= 5;
					count[1]++;
					continue;
				}
				if(money >= 1) {
					money -= 1;
					count[0]++;
					continue;
				}
			}
			
			System.out.println("#"+test);
			for(int i = 7 ; i>=0; i--) {
				System.out.print(count[i] + " ");
			}
			System.out.println();
		}
	}
}
