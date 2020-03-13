import java.util.*;
public class Main {

    // test case
    static int n = 4;
    static int [][] computers = {{1, 0, 1, 0}, {0, 1, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 1}};

    // algorithm solution
    static class Solution {
        static int answer = 0;
        static int [] visited;

        public int solution(int n, int[][] computers) {
            visited = new int[n];
            for(int i=0; i<n; i++){
                if(visited[i] == 0) {
                    visited[i] = 1;
                    answer++;
                }
                dfs(computers,i,n);
            }
            return answer;
        }

        public void dfs(int [][]computers, int edge, int n){
            for(int i=0; i<n; i++){
                if(computers[edge][i] == 1 && visited[i] ==0){
                    visited[i] = 1;
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