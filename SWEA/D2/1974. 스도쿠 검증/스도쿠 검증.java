
import java.util.Arrays;
import java.util.Scanner;

/*
 * 2차원 배열에 스도쿠 배열을 담자
 * 
 * 가로를 쭉 탐색하고, 세로를 쭉 탐색 하며 count 배열에 각 숫자들 인덱스 +1
 * 3x3 배열에 대해서도 반복
 * 
 * isCorrect 메서드를 통해 1~9까지 하나씩 존재하면 1을 리턴
 * 
 * 총 가로 9줄, 세로 9줄, 3x3 9개 총 27개에 대해서 모두 맞는지
 * 
 */
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();

		for (int test = 1; test <= tc; test++) {

			int[][] sudoku = new int[9][9];
			int[] sample = new int[9];
			int[][] square = new int[3][3];

			int[] correct = new int[27];
			int Idx = 0;
			
			for (int r = 0; r < 9; r++) {
				for (int c = 0; c < 9; c++) {
					sudoku[r][c] = sc.nextInt();
				}
			}

			
			// 가로줄 탐색
			for (int r = 0; r < 9; r++) {
				
				for (int c = 0; c < 9; c++) {
					sample[c] = sudoku[r][c];
				}
				
				correct[Idx++] = isCorrect(sample);
			}

			
			// 세로줄 탐색
			for (int r = 0; r < 9; r++) {
				
				for (int c = 0; c < 9; c++) {
					sample[c] = sudoku[c][r];
				}
				
				correct[Idx++] = isCorrect(sample);
			}

			
			// 3x3 탐색

			for (int i = 0; i < 3; i++) {

				int r = i * 3;

				for (int t = 0; t < 3; t++) {

					int c = t * 3;

					for (int row = r; row < r + 3; row++) {

						for (int col = c; col < c + 3; col++) {

							square[row - r][col - c] = sudoku[row][col];

						}
						
					}

					correct[Idx++] = isCorrectSquare(square);
				}

			}

			
			System.out.print("#" + test);
			System.out.println(" " + isSudoku(correct));
			
			
		}
	}

	
	//가로 / 세로 한줄로 된 스도쿠 1~9 있는지 검증
	public static int isCorrect(int[] sample) {
		int[] count = new int[10];

		for (int i = 0; i < 9; i++) {
			count[sample[i]]++;
		}

		//카운트 배열에 1~9 까지 1이 아니면 0 반환
		for (int i = 1; i < 10; i++) {
			if (count[i] != 1) {
				return 0;
			}
		}
		return 1;
	}

	
	//3x3 스도쿠 1~9 있는지 검증
	public static int isCorrectSquare(int[][] square) {
		int[] count = new int[10];
		
		//3x3 스도쿠에 대해서 카운트 배열 +1
		for (int i = 0; i < 3; i++) {
			for (int t = 0; t < 3; t++) {
				count[square[i][t]]++;
			}
		}

		
		//카운트 배열에 1~9 까지 1이 아니면 0 반환
		for (int i = 1; i < 10; i++) {
			if (count[i] != 1) {
				return 0;
			}
		}
		
		return 1;
	}
	
	public static int isSudoku(int[] arr) {
		
		for(int i = 0; i<27; i++) {
			if(arr[i] != 1) {
				return 0;
			}
		}
		
		return 1;
	}
}
