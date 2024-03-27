
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
	static int[] parent;
	static int group;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		StringTokenizer st;
		String str;

		int tc = Integer.parseInt(sc.nextLine());

		for (int test = 1; test <= tc; test++) {

			st = new StringTokenizer(sc.nextLine());

			int N = Integer.parseInt(st.nextToken()); // 사람의 수
			int M = Integer.parseInt(st.nextToken()); // 간선의 수

			group = 0; //
			parent = new int[N+1]; //
			for (int i = 0; i < N+1; i++) {
				parent[i] = i;
			}
			
			for(int i =0; i<M; i++) {
				st = new StringTokenizer(sc.nextLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				union(x,y);
				
			}
			
			for(int i = 1; i< N+1; i++) {
				if(parent[i]==i) {
					group++;
				}
			}
			
			System.out.printf("#%d %d%n",test, group);

		}

	}
	
	public static void union(int x, int y) {
		parent[findset(y)] = findset(x);
	}
	
	public static int findset(int x) {
		if(parent[x] == x) {
			return x;
		}
		
		return findset(parent[x]); 
	}
}
