
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

		int[] time = new int[100001];
		boolean[] visited = new boolean[100001];

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		if (N >= K) {
			System.out.println(N - K);
            System.out.println(1);
			return;
		}

		Queue<Integer> queue = new LinkedList<>();

		queue.offer(N);
		int now = 0;
		int next = 0;
		int count = 0;
		int min = Integer.MAX_VALUE;
		time[N] = 0;
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
					//숨바꼭질 1과 다르게 최단 경로의 수를 구해야 한다. 그러기 위해서 ac
					if (time[next] == 0 || time[next] >= time[now] + 1) {
						time[next] = time[now] + 1;
						queue.offer(next);

						if (next == K && time[next] <= min) {
							min = time[next];
							count++;
						}
					}
				}
			}
		}

		System.out.println(time[K]);
		System.out.println(count);

	}
}
