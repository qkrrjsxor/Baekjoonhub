
import java.util.Scanner;
import java.util.StringTokenizer;

/*
 * 연결 리스트를 구현하여 삽입, 삭제, 추가 기능을 만들어보자
 * 
 * 복잡한 입력을 받기 위해 stringtokenizer를 이용해보자
 * 
 */
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st;

		for (int test = 1; test <= 10; test++) {

			int num = Integer.parseInt(sc.nextLine());

			LinkedList list = new LinkedList();
			String input = sc.nextLine();

			st = new StringTokenizer(input);

//			System.out.println(num);

			for (int i = 0; i < num; i++) {
//				System.out.println("i : " + i);
				list.addLast(Integer.parseInt(st.nextToken()));
//				System.out.println(st.nextToken());
			}

			int n = Integer.parseInt(sc.nextLine());
			input = sc.nextLine();

			st = new StringTokenizer(input);

			for (int i = 0; i < n; i++) {
				String temp = st.nextToken();
				
				if (temp.equals("I")) {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());

					for (int t = 0; t < y; t++) {
						int item = Integer.parseInt(st.nextToken());
						list.add(x+t, item);
					}

				} else if (temp.equals("D")) {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					
					for (int t = 0; t < y; t++) {
						list.delete(x);
					}

				} else if (temp.equals("A")) {
					
					int y = Integer.parseInt(st.nextToken());

					for (int t = 0; t < y; t++) {
						int item = Integer.parseInt(st.nextToken());
						list.addLast(item);
					}
				}
			}
			
			System.out.print("#" + test);
			for(int i = 0; i< 10; i++) {
				list.printList(i);
			}
			System.out.println();

		}

	}
}

class Node {
	int data;
	Node link;

	Node() {
	}

	Node(int data) {
		this.data = data;
	}
}

class LinkedList {
	Node head = new Node();
	int size = 0;

	void add(int idx, int data) {
		if (idx < 0 || idx > size) {
			return;
		}

		Node newNode = new Node(data);
		Node temp = head;

		for (int i = 0; i < idx; i++) { // temp 는 삽입할 위치 앞의 노드 가리킴
			temp = temp.link;
		}

		newNode.link = temp.link;
		temp.link = newNode;

		size++;

	}

	void addLast(int data) {
		Node newNode = new Node(data);
		Node temp = head;

		while (temp.link != null) { // temp는 마지막 노드를 가리킴
			temp = temp.link;
		}

		temp.link = newNode;

		size++;

	}

	void delete(int idx) {
		Node temp = head;

		for (int i = 0; i < idx; i++) { // temp는 지울 노드의 앞 노드를 가리킴
			temp = temp.link;
		}

		temp.link = temp.link.link;

		size--;
	}

	void printList(int idx) {
		Node temp = head;

		for (int i = 0; i <= idx; i++) {
			temp = temp.link;
		}

		System.out.print(" " + temp.data);
	}
}