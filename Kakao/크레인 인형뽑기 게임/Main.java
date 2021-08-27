import java.util.*;

public class Main {
    //test case
    static int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
    static int[] moves = {1,5,3,5,1,2,1,4};

    //algorithm solution
    static class Solution {
        public int solution(int[][] board, int[] moves) {
            int answer = 0;
            Stack<Integer> stack = new Stack<>();

            for(int i=0; i<moves.length; i++) {
                int idx = moves[i] - 1;
                for (int j = 0; j < board[idx].length; j++) {
                    int doll = board[j][idx];
                    if (doll != 0) {
                        if (!stack.empty() && stack.peek() == doll) {
                            answer += 2;
                            stack.pop();
                        }
                        else
                            stack.push(doll);
                        board[j][idx] = 0;
                        break;
                    }
                }
            }
            return answer;
        }
    }

    // result
    public static void main(String[] args) {
        Solution solution = new Solution();
        int answer = solution.solution(board,  moves);
        System.out.println(answer);
    }
}