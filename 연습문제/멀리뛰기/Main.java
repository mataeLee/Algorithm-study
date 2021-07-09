import java.util.*;

public class Main {
    // 프로그래머스 Lv.3 멀리뛰기

    //test case
    static int n = 4;

    //algorithm solution
    static class Solution {
        public long solution(int n) {
            if (n < 2) return 1;
            int[] dp = new int[n + 1];
            dp[1] = 1;
            dp[2] = 2;
            for (int i = 3; i <= n; i++) {
                dp[i] = dp[i - 1] % 1234567 + dp[i - 2] % 1234567;
            }
            return dp[n] % 1234567;
        }
    }
    // result
    public static void main(String[] args) {
        Solution solution = new Solution();
        long answer = solution.solution(n);
//        System.out.print("[");
//        for(int i=0; i<answer.length; i++){
//            System.out.print(answer[i]);
//            if(i < answer.length - 1) System.out.print(", ");
//        }
//      System.out.print("]");
        System.out.println(answer);
    }
}