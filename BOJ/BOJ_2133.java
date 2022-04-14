import java.io.*;
import java.util.*;

public class Main {
    // 백준 dp 타일 채우기 - 2133
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[31];
        dp[0] = 1;
        dp[1] = 0;
        dp[2] = 3;

        for(int i=4; i<=n; i+=2){
            dp[i] = dp[i-2] * dp[2];
            for(int j=0; j<i-2; j+=2){
                dp[i] += dp[j] * 2;
            }
        }
        System.out.println(dp[n]);
    }
}