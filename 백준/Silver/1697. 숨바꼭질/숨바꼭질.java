
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 수빈
		int K = Integer.parseInt(st.nextToken()); // 동생

		// bfs
		int[] time = new int[100001];

		Queue<Integer> queue = new LinkedList<>();

		queue.offer(N);

		time[N] = 0;

		int now = 0;
		int next = 0;
		int min = Integer.MAX_VALUE;
		
		if(N>=K) {
			System.out.println(N-K);
			return;
		}
		// bfs시작
		while (!queue.isEmpty()) {
			now = queue.poll();

			for (int i = 0; i < 3; i++) {
				if (i == 0)
					next = now - 1;
				else if (i == 1)
					next = now + 1;
				else if (i == 2)
					next = now * 2;

				if (next >= 0 && next < 100001) {
					if(time[next] == 0 || time[next] > time[now]+1) {
						
						time[next] = time[now] +1;
						queue.offer(next);
					}
				}
			}
		}
		
		System.out.println(time[K]);
	}
}
