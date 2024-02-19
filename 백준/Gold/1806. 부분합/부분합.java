import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		// N : 문자열 길이, S : 목표한 합 값
		String str = br.readLine();
		st = new StringTokenizer(str);
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());

		int min = Integer.MAX_VALUE;

		// 숫자들을 배열에 넣어주기
		str = br.readLine();
		st = new StringTokenizer(str);

		int[] numArr = new int[N + 1];
		int i = 1;

		while (st.hasMoreTokens()) {
			numArr[i] = Integer.parseInt(st.nextToken());

			numArr[i] = numArr[i] + numArr[i - 1];
			i++;
		}

		int start = 0;
		int end;
		int temp1 = N+1;
		int temp2 = start;
        if(numArr[N] - numArr[N-1] >= S) {
			System.out.println(1);
			System.exit(0);
		}
		for (; start < N; start++) {

			end = (start + N) / 2;
			temp1 = N+1;
			temp2 = start;
			
			while (end != temp1 && end != temp2) {

				int sum = numArr[end] - numArr[start];
//				System.out.println("start : " + start + " end : " + end + " temp1 : " + temp1);
				if (sum < S) {

					temp2 = end;
					end = (temp2 + temp1) / 2;
					
				} else {

					if ((end - start) < min) {
						min = end - start;
					}
					
					temp1 = end;
					end = (temp2 + temp1) / 2;

				}

			}
		}

		// 출력
		if (min == Integer.MAX_VALUE) {
//			bw.write(0);
//			bw.flush();
			System.out.println(0);
		} else {
//			bw.write(min);
//			bw.flush();
			System.out.println(min);
		}
	}

}
