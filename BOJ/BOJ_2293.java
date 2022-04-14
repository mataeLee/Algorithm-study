import java.io.*;
import java.util.*;

public class Main {
    // 백준 DP 동전 1 - 2293

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        Integer[] coins = new Integer[Integer.parseInt(strs[0])];

        int k = Integer.parseInt(strs[1]);

        int dp[] = new int[k+1];
        dp[0] = 1;

        for(int i=0; i<coins.length; i++){
            coins[i] = Integer.parseInt(br.readLine());
            for(int j=coins[i]; j<=k; j++){
                dp[j] += dp[j - coins[i]];
            }
        }
        System.out.println(dp[k]);
    }
}