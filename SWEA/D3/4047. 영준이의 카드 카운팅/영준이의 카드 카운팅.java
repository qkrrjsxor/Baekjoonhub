
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int[] spade;
	static int[] diamond;
	static int[] heart;
	static int[] clover;
	static int s;
	static int d;
	static int h;
	static int c ;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = Integer.parseInt(sc.nextLine());

		test: for (int test = 1; test <= tc; test++) {

			String str = sc.nextLine();

			char[] cards = str.toCharArray();

			spade = new int[14];
			diamond = new int[14];
			heart = new int[14];
			clover = new int[14];
			s = 13;
			d = 13;
			h = 13;
			c = 13;

			for (int i = 0; i < cards.length; i = i + 3) {
				char ch = cards[i];

				int num = (cards[i + 1] - '0') * 10 + (cards[i + 2] - '0');

				if (ch == 'S') {

					spade[num]++;
					s--;

				} else if (ch == 'D') {
					diamond[num]++;
					d--;

				} else if (ch == 'H') {
					heart[num]++;
					h--;
				} else if (ch == 'C') {
					clover[num]++;
					c--;
				}
			}

			for (int i = 0; i < 13; i++) {
				if (spade[i] >= 2 || diamond[i] >= 2 || heart[i] >= 2 || clover[i] >= 2) {
					System.out.println("#" + test + " ERROR");
					continue test;
				}
			}

			System.out.printf("#%d %d %d %d %d%n", test, s, d, h, c);

		}
	}
}
