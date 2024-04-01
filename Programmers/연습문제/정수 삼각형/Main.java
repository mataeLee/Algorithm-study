import java.util.*;

public class Main {
    //test case
    static int[][] triangle= {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};

    //algorithm solution
    static class Solution {
        public int solution(int[][] triangle) {
            int answer = 0;
            int dp[][] = new int[triangle.length][triangle.length];
            dp[0][0] = triangle[0][0];

            for(int i=1; i<triangle.length; i++){
                dp[i][0] = triangle[i][0] + dp[i-1][0];
                for(int j=1; j<triangle[i].length; j++){
                    dp[i][j] = Math.max(triangle[i][j] + dp[i-1][j], triangle[i][j] + dp[i-1][j-1]);
                }
            }
            for(int i=0; i<dp[triangle.length-1].length; i++){
                if(answer < dp[triangle.length-1][i])
                    answer = dp[triangle.length-1][i];
            }
            return answer;
        }
    }


    // result
    public static void main(String[] args) {
        Solution solution = new Solution();
        int answer = solution.solution(triangle);
        System.out.println(answer);
    }
}