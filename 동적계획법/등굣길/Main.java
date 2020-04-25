import java.util.*;

public class Main {

    // test case
    static int m = 4;
    static int n = 3;
    static int[][] puddles = {{2, 2}};

    // algorithm solution
    static class Solution {
        static int [][] map;
        public int solution(int m, int n, int[][] puddles) {
            map = new int[n+1][m+1];
            return dp(puddles, m, n, 1, 1);
        }

        public int dp(int[][] puddles, int m, int n, int i, int j){
            if(i > n || j > m)
                return 0;
            if(i == n && j == m)
                return 1;
            if(map[i][j] > 0) return map[i][j];
            for(int idx=0; idx<puddles.length; idx++){
                if(i == puddles[idx][1] && j == puddles[idx][0])
                    return 0;
            }
            return map[i][j] = dp(puddles, m, n, i+1, j)%1000000007 + dp(puddles, m, n, i, j+1)%1000000007;
        }
    }

    // result
    public static void main(String[] args) {
        Solution solution = new Solution();
        int answer = solution.solution(m, n, puddles);
        System.out.println(answer);
    }
}