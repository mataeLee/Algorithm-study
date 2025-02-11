import java.util.*;

public class Solution {
    // leetcode 79.Word Search
    static boolean answer = false;
    public boolean exist(char[][] board, String word) {


        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                DFS(board, word, visited, i, j, 0);
            }
        }

        return answer;
    }

    public void DFS(char[][] board, String word, boolean[][] visited, int i, int j, int depth) {
        if(depth == word.length()){
            answer = true;
            return;
        }

        if(i < 0 || j < 0 || i == board.length || j == board[0].length || visited[i][j] || board[i][j] != word.charAt(depth)){
            return;
        }

        visited[i][j] = true;
        DFS(board, word, visited, i + 1, j, depth + 1);
        DFS(board, word, visited, i - 1, j, depth + 1);
        DFS(board, word, visited, i, j + 1, depth + 1);
        DFS(board, word, visited, i, j - 1, depth + 1);
        visited[i][j] = false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // make testcase

        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";

        System.out.println(solution.exist(board, word));
    }
}