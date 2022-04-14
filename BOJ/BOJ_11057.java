import java.io.*;
import java.util.*;

public class Main {
    // 백준 dp 오르막 수 - 11057
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int len = Integer.parseInt(br.readLine());
        long[][] arr = new long[1001][10];
        for(int i=0; i<10; i++){
            arr[1][i] = 1;
            arr[2][i] = i+1;
        }
        for(int i=3; i<=len; i++){
            for(int j=0; j<10; j++){
                long sum = 0;
                for(int k=0; k<=j; k++){
                    sum += arr[i-1][k];
                }
                arr[i][j] = sum%10007;
            }
        }
        long answer = 0;
        for(int i=0; i<10; i++){
            answer += arr[len][i];
        }
        System.out.println(answer%10007);
    }
}