
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
	static int[] nums;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st;

		int tc = Integer.parseInt(sc.nextLine());

		for (int test = 1; test <= tc; test++) {

			String str = sc.nextLine();
			st = new StringTokenizer(str);
			nums = new int[10];
			for (int t = 0; t < 10; t++) {
				nums[t] = Integer.parseInt(st.nextToken());
			}

			// 정렬
			int max = -1;
			int maxidx = 0;
			int temp;
			for (int i = 0; i < 10; i++) {
				max = -1;
				for (int t = i; t < 10; t++) {
					if (nums[t] > max) {
						max = nums[t];
						maxidx = t;
					}
				}
				temp = nums[i];
				nums[i] = max;
				nums[maxidx] = temp;
			}

//			System.out.println(Arrays.toString(nums));

			int sum = 0;
			for (int i = 1; i < 9; i++) {
				sum += nums[i];
			}
			
			int result;
			if (sum % 8 >= 4) {
				result = sum / 8 + 1;
			} else {
				result = sum / 8;
			}
			
			System.out.println("#" + test + " " + result);
		}
	}
}
