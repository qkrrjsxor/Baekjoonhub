import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
	static int D, W, K;	// D: 행 (3~13), W : 열(1~20), K : 통과기준(1~D)
	static int[][] film; 	//보호필름
	static int ans;		//최소 주사 투약 횟수
	
	public static void main(String[] args ) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int test = 1; test <= tc; test++) {
			D = sc.nextInt();
			W = sc.nextInt();
			K = sc.nextInt();
			film = new int[D][W];
			
			for(int i =0 ;i < D; i++) {
				for(int j = 0; j<W; j++) {
					film[i][j] = sc.nextInt();
				}
			}//	보호필름 입력완료
			
			ans = 987654321; 	//이것도 좋지만 K로 초기화해도 된다
			
			makeFilm(0,0);
			
			System.out.println("#"+test+" "+ans);
		}//tc
	}//main
	
	//row : 현재 약품을 주입할 행
	//cnt : 약품을 주입한 횟수
	public static void makeFilm(int row, int cnt) {
		////base 
		if(isOk()) {
			ans = Math.min(ans, cnt);
			return;
		}
		if(ans < cnt) {	//내가 가진 정답보다 약 투여 횟수가 크면 필요없어
			return;
		}
		if(row==D) return;
		
		
		//// recursive 
		//주입 안하는 경우
		makeFilm(row+1, cnt);
		
		//약품을 주입하기ㅣ 전 원상복구를 위해 메모리 할당해서 저장을 해두자
		int[] tmp = new int[W];
		for(int i =0; i < W; i++) {
			tmp[i] = film[row][i];
		}//row 행의 값을 deep copy
		
		//A 주입(0)
		//약품 주입하는
		yak(row,0);
		makeFilm(row+1, cnt+1);
		
		//B 주입(1)
		//약품 주입하는
		yak(row,1);
		makeFilm(row+1, cnt+1);
		
		//원상복구 (투약 전원본 필름으로)
		for(int i = 0 ; i < W; i++) {
			film[row][i] = tmp[i];
		}
	}
	
	
	private static boolean isOk() {
		for(int c = 0; c <W; c++) {
			boolean flag = false;
			int cnt = 1;
						
			for(int r = 1; r < D; r++) {
				if(film[r][c]==film[r-1][c]) {
					cnt++;
				}
				else {
					cnt = 1;
				}
				
				if(cnt>=K) {
					flag = true;
					break;
				}
			}//한 열 검사 완료
			//한 열에서 flag가 false이면 검사 실패
			if(flag==false) {
				return false;
			}
		}
		
		//열 검사 다 하고 여기까지 도착했으면 통과 한거야
		return true;
	}

	//row 번째 행에다가 drug 약품을 주입한다
	public static void yak(int row, int drug) {
		for(int i = 0; i< W; i++) {
			film[row][i] = drug;
		}
	}
}
