
import java.util.Scanner;
import java.util.StringTokenizer;

/*
 * 문자열의 길이 : 30
 * 마디의 최대 길이 : 10
 * 
 * 마디의 길이 1부터 10까지 노가다 반복
 */
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st;

		int tc = Integer.parseInt(sc.nextLine());
		for (int test = 1; test <= tc; test++) {

			String str = sc.nextLine();
			char[] phrase = str.toCharArray();
			char[] madi;

			int len = 1;
			loop : for (len = 1; len <= 10; len++) {

				for (int i = 0; i < len; i++) {

					
					if(phrase[i] != phrase[i+len]) {
						continue loop;
					}
					if(i==len-1) {
						break loop;
					}
					
				}

			}
			
			System.out.println("#"+test + " " + len);
		}
	}
}
