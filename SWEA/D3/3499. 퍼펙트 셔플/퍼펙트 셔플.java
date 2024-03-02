
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st;

		int test = Integer.parseInt(sc.nextLine());

		for (int tc = 1; tc <= test; tc++) {
			int N = Integer.parseInt(sc.nextLine());
			Queue result = new Queue(N);
			Queue q1 = new Queue(N/2+1);
			Queue q2 = new Queue(N/2+1);
			String s = sc.nextLine();
			st = new StringTokenizer(s);
			
			for (int i = 0; i < Math.round(N/2.0); i++) {
				q1.enQueue(st.nextToken());
				
			}
			for (int i = 0; i < N/2; i++) {
				
				q2.enQueue(st.nextToken());
			}
			
			System.out.printf("#%d ",tc);
			for(int i = 0; i <= N/2; i++) {
				System.out.print(q1.deQueue() + " ");
				System.out.print(q2.deQueue() + " ");
			}
			System.out.println();
		}

	}
}


class Queue {
	String[] queue;
	int front = -1, rear = -1;
	
	public Queue(int n) {
		queue = new String[n];
	}
	
	public  void enQueue(String data) {
		if(isFull()) {
			System.out.println("큐가 꽉 차있어요");
			return;
		}
		
		queue[++rear] = data;
	}
	
	public  String deQueue() {
		if(isEmpty()) {
//			System.out.println("큐가 비어있어요");
			return "";
		}
		String item = queue[++front];
		
		return item;
	}
	
	public  boolean isFull() {
		return rear == queue.length -1;
	}
	
	public  boolean isEmpty() {
		return front == rear;
	}
}