import java.io.*;
import java.util.*;

public class Main{
    // 백준 그리디 동전0 - 11047
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        int n = Integer.parseInt(strs[0]);
        int amount = Integer.parseInt(strs[1]);
        int[] coins = new int[n];
        for(int i=0; i<n; i++){
            coins[n-i-1] = Integer.parseInt(br.readLine());
        }
        int res = 0;
        for(int i=0; i<n; i++){
            if(amount / coins[i] > 0){
                res += amount / coins[i];
                amount %= coins[i];
            }
        }
        System.out.println(res);
    }
}