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
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		

		for(int test_case = 1; test_case <= T; test_case++)
		{
			sc.nextInt();
			int max = -1;
			int maxIndex = -1;
			
			//0점 ~ 100점 까지 101 개의 배열을 만들어 각 점수에 해당하는 인덱스 
			int[] nums = new int[101]; 
			
			//1000명 학생의 점수를 하나씩 입력받으며 입력 받은 점수에 따라 
			//해당하는 인덱스의 배열에 +1 을 한다.
			for(int i = 0; i< 1000; i++) {
				nums[sc.nextInt()] += 1;
			}
			
			//nums 배열 조회하며 최대값 찾기
			//nums 의 최대값의 인덱스 == 최빈수 이기 때문이다.
			//조회 할때 nums[i] >= max 로 크거나 같다 를 비교식으로 넣으면
			//최빈수가 여러개 있을 때 최빈수 중 가장 큰 수를 출력 할 수 있다.
			for(int i = 0; i<101; i++) {
				if(nums[i] >= max) {
					max = nums[i];
					maxIndex = i;
				}
			}
			
			System.out.print("#" + test_case);
			System.out.println(" " + maxIndex);

		}
	}
}