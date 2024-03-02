/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	//회문인지 판별하는 메서드
	//회문이면 1, 아니면 0을 리턴
	public static int isPalindrom(char[] text) {
		int len = text.length;
		
		for(int i =0; i < len; i++) {
			//회문이 아니면 0을 리턴
			if(text[i] != text[len-1-i])
				return 0;
		}
		
		return 1;
	}
	
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=10;
		

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int textLength = sc.nextInt();
			
			
			char[][] text = new char[8][8];
			
			
			//8줄로 이루어진 문자열 입력 받아서 
			//8x8 char text 배열에 넣기
			// 이것부터 너무 힘들었따....
			for(int r= 0 ; r<8; r++) {
				int cnt = 0;
				String str = sc.next();
				for(int c= 0; c<8; c++) {
					
					text[r][c]= str.charAt(cnt);

					cnt++;
					
				}
			}
			
			int count = 0;
			char[] sample = new char[textLength];
			
			//가로 탐색
			for(int r = 0; r < 8; r++) {
				for(int c = 0; c < 8-textLength+1; c++) {
					for(int i = c; i < c+ textLength; i++) {
						
						sample[i-c] = text[r][i];

					}
					count += isPalindrom(sample);
				}
			}
			
			//세로 탐색
			for(int r = 0; r < 8; r++) {
				for(int c = 0; c < 8-textLength+1; c++) {
					for(int i = c; i < c+ textLength; i++) {
						
						sample[i-c] = text[i][r];

					}
					count += isPalindrom(sample);
				}
			}
			
			System.out.print("#" + test_case);
			System.out.println(" " + count);
		}
	}
}