
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			String original_memory = sc.next(); //원래의 메모리값

			int len = original_memory.length(); 
			int[] bitArr = new int[len];
			int[] zero = new int[len];
			int count = 0;
			
			//입력받은 비트값들을 각 자리별로 정수로 변환하여 bitArr에 저장
			for(int i=0; i<len; i++) {
				bitArr[i] = Integer.parseInt(original_memory.substring(i, i+1));
				zero[i] = 0;		//zero 배열 모두 0으로 초기화
			}
			
			for(int i=0; i<len; i++) {	
				if(bitArr[i] != zero[i]) {
					if(zero[i] ==0) {
						for(int t=i; t<len; t++) zero[t]=1;
					}else if(zero[i] == 1) {
						for(int t=i; t<len; t++) zero[t]=0;
					}
					count++;
				}
			}
			
			System.out.print("#"+test_case + " ");
			System.out.println(count);

		}
	}
}