import java.util.Arrays;
import java.util.Scanner;
 
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        int tc = sc.nextInt();
         
        for(int test = 1; test <= tc; test++) {
             
            int N = sc.nextInt();
            int M = sc.nextInt();
            int max = -1;
            int maxIndex = 0;
             
            int[] count = new int[N+M+1];
             
            for(int n = 1; n<=N; n++) {
                 
                for(int m = 1; m<=M; m++) {
                     
                    count[n+m]++;
                     
                }
            }
             
            for(int i = 1; i <= N+M; i++) {
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