
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
	
	static class FittedStack {
		
		private char[] elements;
		private int top;
		
		FittedStack () {
			this.elements = new char[100000];
			this.top = -1;
		}
		
		public int size() {
			return elements.length;
		}
		
		// top 위치를 반환하는 메서드 추가
		public int top() {
			return top;
		}
		
		public boolean isEmpty() {
			return top == -1;
		}
		
		public boolean isFull() {
			return top == elements.length-1;
		}
		
		public void push(char c) {
			// full 될 일이 없음 최대 10만 개 이므로
			elements[++top] = c;
		}
		
		public char pop() {
			// 문제 조건에서 비어있는 경우 없음
			char removedElement = elements[top];
			elements[top] = '\u0000';
			top--;
			return removedElement;
		}
		
		public char peek() {
			// 문제 조건에서 비어있는 경우 없음
			return elements[top];
		}
		
		public void printStack() {
			
			for (int i=0; i<=top; i++) {
				System.out.print(elements[i]);
			}
			System.out.print("\n");
			
		}
		
	}
	
	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		
//		File file = new File("./src/swea_5432_쇠막대기자르기/input.txt");
//		Scanner sc = new Scanner(file);
		
		int T = Integer.parseInt(sc.nextLine());
		
		FittedStack fittedStack;
		
		for (int tc=1; tc<=T; tc++) {
			
			String line = sc.nextLine().trim();
			
			// 문제의 조건에 부합하는 fittedStack을 매 tc마다 초기화
			fittedStack = new FittedStack();
			
			int sum = 0;
			char last = ' ';
			
			
			for (int i=0; i<line.length(); i++) {
				if (line.charAt(i) == '(') {
					fittedStack.push(line.charAt(i));
					// 마지막에 오는 문자 '('
					last = '(';
				} else {
					// 이전의 문자가 무엇이었냐에 따라 더해지는 값이 달라짐
					if (last == '(') {
						sum += fittedStack.top();
					} else {
						sum += 1;
					}
					fittedStack.pop();
					// 마지막에 오는 문자 ')'
					last = ')';
				}
				
			}
			
			System.out.printf("#%d %d\n", tc, sum);
			
		}
		
	}
}