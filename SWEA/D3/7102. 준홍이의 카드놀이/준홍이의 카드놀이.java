
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int test = 1; test <= tc; test++) {
			
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			//root Node 생성
			Node root = new Node(1);
			
			//합의 빈도수 저장할 count 배열
			int[] count = new int[N+M+1];
			
			
			//root의 자손 노드들로 1~N 까지 데이터를 갖고있는 자손 노드 생성
			for(int i = 1; i <= N; i++) {
				
				root.child.add(new Node(i));
				
				//1~N 까지의 노드에 각각 자손노드로 1~M 까지 자손노드 생성 
				for(int m = 1; m <= M; m++) {
					root.child.get(i-1).child.add(new Node(m));
				}
			}
			
			
			//1층 노드와 2층 노드의 합을 구하며 count 배열 +1
			for(int i=0; i<N; i++) {
				
				for(int t = 0; t < M; t++) {
					int temp1 = root.child.get(i).data;
					int temp2 = root.child.get(i).child.get(t).data;
					
					count[temp1 + temp2] ++;
				}
			}
			
			int max = -1;
			int maxIndex = 0;
			
			for(int i = 0; i < N+M+1; i++) {
				if(count[i] > max) {
					max = count[i];
					maxIndex = i;
				}
				
			}
			
			System.out.print("#" + test );
			for(int i = 1; i <= N+M; i++) {
				if(count[i] == max) {
					System.out.print(" " +i);
				}
			}
			System.out.println();
			
		}
	}
}	


class Node{
	int data;
	List<Node> child = new ArrayList<>();
	
	public Node() {}
	
	public Node(int data) {
		this.data = data;
	}
}
