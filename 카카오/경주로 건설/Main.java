import java.util.*;

public class Main {
    // 프로그래머스 Lv.3 경주로 건설

    //test case
//    static int[][] board = {{0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0},{0,0,0,0,0,1,0,0},{0,0,0,0,1,0,0,0},{0,0,0,1,0,0,0,1},{0,0,1,0,0,0,1,0},{0,1,0,0,0,1,0,0},{1,0,0,0,0,0,0,0}};
//    static int[][] board = {{0,0,0}, {0,0,0}, {0,0,0}};
//    static int[][] board = {{0,0,1,0}, {0,0,0,0}, {0,1,0,1}, {1,0,0,0}};
    static int[][] board = {{0,0,0,0,0,0},{0,1,1,1,1,0},{0,0,1,0,0,0},{1,0,0,1,0,1},{0,1,0,0,0,1},{0,0,0,0,0,0}};

    //algorithm solution
    static class Solution {
        public int solution(int[][] board) {
            // 비용이 가장 적게 탐색 직선 100원 코너 600원
            for(int i=0; i<board.length; i++){
                for(int j=0; j<board.length; j++){
                    if(board[i][j] != 1){
                        board[i][j] = Integer.MAX_VALUE;
                    }
                }
            }
            dp(0, 0, board, 0, -1);
            return board[board.length-1][board.length-1];
        }
    }

    public static void dp(int startX, int startY, int[][] board, int mount, int dir){
        if(startX == board.length || startY == board.length || startX < 0 || startY < 0) return; // 넘어가는 경우

        if(board[startX][startY] < mount) return; // 벽이거나 의미 없는 경로인 경우
        board[startX][startY] = mount;

        if(dir == -1) { // 출발점
            dp(startX+1, startY, board, 100, 6);
            dp(startX, startY+1, board, 100, 9);
        }

        switch (dir) {  // dir 방향 12, 3, 6, 9
            case 12: // 12시 방향, 6시 제외
                dp(startX - 1, startY, board, mount+100, 12);
                dp(startX, startY + 1, board, mount+600, 3);
                dp(startX, startY - 1, board, mount+600, 9);
                break;
            case 3: // 3시 방향, 9시 제외
                dp(startX - 1, startY, board, mount+600, 12);
                dp(startX, startY + 1, board, mount+100, 3);
                dp(startX + 1, startY, board, mount+600, 6);
                break;
            case 6: // 6시 방향, 12시 제외
                dp(startX, startY + 1, board, mount+600, 3);
                dp(startX + 1, startY, board, mount+100, 6);
                dp(startX, startY - 1, board, mount+600, 9);
                break;
            case 9: // 9시 방향, 3시 제외
                dp(startX - 1, startY, board, mount+600, 12);
                dp(startX + 1, startY, board, mount+600, 6);
                dp(startX, startY - 1, board, mount+100, 9);
                break;
        }
    }
    // result
    public static void main(String[] args) {
        Solution solution = new Solution();
        int answer = solution.solution(board);
//        System.out.print("[");
//        for(int i=0; i<answer.length; i++){
//            System.out.print(answer[i]);
//            if(i < answer.length - 1) System.out.print(", ");
//        }
//      System.out.print("]");
        System.out.println(answer);
    }
}