import java.util.*;

public class Solution {
    //test case
    static char[][] grid = {
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}};

    //algorithm solution
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int answer = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1'){
                    dfs(i, j, grid, m, n);
                    answer++;
                }
            }
        }
        return answer;
    }

    void dfs(int x, int y, char[][] grid, int m, int n) {
        if(x < 0 || x >= m) return;
        if(y < 0 || y >= n) return;
        if(grid[x][y] == '0') return;
        grid[x][y] = '0';
        dfs(x+1, y, grid, m, n);
        dfs(x-1, y, grid, m, n);
        dfs(x, y+1, grid, m, n);
        dfs(x, y-1, grid, m, n);
    }

    // result
    public static void main(String[] args) {
        Solution solution = new Solution();

//        System.out.println(Result.linked_list(solution.reverseList(head)));
        System.out.println(Result.literal(solution.numIslands(grid)));
//        System.out.println(Result.one_demension(num1));
//        System.out.println(Result.two_demension(solution.levelOrder(null)));
    }
}