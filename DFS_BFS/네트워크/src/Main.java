import java.util.*;
public class Main {

    // test case
    static int n = 4;
    static int [][] computers = {{1, 0, 1, 0}, {0, 1, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 1}};

    // algorithm solution
    static class Solution {
        static int answer = 0;
        static boolean [] visited;

        public int solution(int n, int[][] computers) {
            visited = new boolean[n];
            for(int i=0; i<n; i++){
                if(visited[i] == false) {
                    visited[i] = true;
                    answer++;
                }
                dfs(computers,i,n);
            }
            return answer;
        }

        public void dfs(int [][]computers, int edge, int n){
            for(int i=0; i<n; i++){
                if(computers[edge][i] == 1 && visited[i] == false){
                    visited[i] = true;
                    dfs(computers, i, n);
                }
            }
        }
    }

    // result
    public static void main(String[] args) {
        Solution solution = new Solution();
        int answer = solution.solution(n, computers);
        System.out.println(answer);
    }
}