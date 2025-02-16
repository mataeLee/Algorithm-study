import java.util.*;

public class Solution {
    // leetcode 64. Minimum Path Sum
    public int minPathSum(int[][] grid) {
        int[][] sumArr = new int[grid.length][grid[0].length];

        sumArr[0][0] = grid[0][0];

        // 첫째 행 계산
        for(int i = 1; i < grid.length; i++) {
            sumArr[i][0] = grid[i][0] + sumArr[i-1][0];
        }

        // 첫째 열 계산
        for(int j = 1; j < grid[0].length; j++) {
            sumArr[0][j] = grid[0][j] + sumArr[0][j-1];
        }

        // 1행 전 값과 1열 전 값 중 작은 값으로 더하기 
        for(int i=1; i<sumArr.length; i++) {
            for(int j=1; j<sumArr[0].length; j++) {
                sumArr[i][j] = Math.min(sumArr[i-1][j], sumArr[i][j-1]) + grid[i][j];
            }
        }

        return sumArr[grid.length - 1][grid[0].length - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // make testcase
        int[][] grid = new int[][]{{1,2,3},{4,5,6}};
        System.out.println(solution.minPathSum(grid));
    }
}