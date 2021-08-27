import java.util.*;

public class Main {
    //test case
    static int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
    static int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};

    //algorithm solution
    static class Solution {
        public boolean solution(int[][] key, int[][] lock) {
            int N = lock.length;
            int M = key.length;
            // 열쇠 넣은 결과 배열
            int[][] res = new int[N][N];
            int[][] mem = new int[2 * M + N - 2][2 * M + N - 2];
            int[][] sub_key = new int[M][M];
            //회전 수
            for (int r = 0; r < 4; r++) {
                // key 복사 및 위치 조정
                for (int i = 0; i < M + N - 1; i++) {
                    for (int j = 0; j < M + N - 1; j++) {
                        for (int x = 0; x < 2 * M + N - 2; x++) {
                            for (int y = 0; y < 2 * M + N - 2; y++) {
                                if (x >= i && x < i + M && y >= j && y < j + M)
                                    mem[x][y] = key[x - i][y - j];
                                else
                                    mem[x][y] = -1;

                            }
                        }
                        // 열쇠 끼우는 과정
                        for (int x = 0; x < N; x++) {
                            for (int y = 0; y < N; y++) {
                                if(mem[x + M - 1][y + M - 1] == -1) res[x][y] = lock[x][y];
                                else res[x][y] = mem[x + M - 1][y + M - 1] ^ lock[x][y];
                            }
                        }
                        // 열쇠 넣은 결과 체크
                        if (check(res)) return true;
                    }
                }
                // 90도 회전
                for (int a = 0; a < M; a++) {
                    for (int b = 0; b < M; b++) {
                        sub_key[a][b] = key[M - 1 - b][a];
                    }
                }
                for (int a = 0; a < M; a++) {
                    for (int b = 0; b < M; b++) {
                        key[a][b] = sub_key[a][b];
                    }
                }
            }
            return false;
        }

        public boolean check(int[][] arr){
            for(int i=0; i<arr.length; i++){
                for(int j=0; j<arr.length; j++){
                    if(arr[i][j] == 0) return false;
                }
            }
            return true;
        }
    }

    // result
    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean answer = solution.solution(key, lock);
        System.out.println(answer);
    }
}