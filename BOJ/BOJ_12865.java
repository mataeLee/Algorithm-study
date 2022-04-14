import java.io.*;
import java.util.*;

public class Main {
    // 백준 dp 평범한 배낭 - 12865
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");

        int n = Integer.parseInt(strs[0]);
        int k = Integer.parseInt(strs[1]);

        int[] w = new int[n];
        int[] v = new int[n];
        int[] dp = new int[k+1];

        for(int i=0; i<n; i++){
            String[] val = br.readLine().split(" ");
            w[i] = Integer.parseInt(val[0]);
            v[i] = Integer.parseInt(val[1]);
        }

        for(int i=0; i<n; i++){
            for(int j=k; j >= w[i]; j--){
                dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);
            }
        }
        System.out.println(dp[k]);
    }
}