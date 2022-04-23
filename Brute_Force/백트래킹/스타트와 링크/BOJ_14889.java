import java.io.*;
import java.util.*;

public class Main{
    // 백준 백트래킹 스타트와 링크 - 14889
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] s = new int[n][n];
        for(int i=0; i<n; i++){
            String[] strs = br.readLine().split(" ");
            for(int j=0; j<strs.length; j++){
                s[i][j] = Integer.parseInt(strs[j]);
            }
        }
        int[] out = new int[n];
        boolean[] visited = new boolean[n];
        backtracking(s, 0, visited, out);
        System.out.println(min);
    }

    private static void backtracking(int[][] s, int depth, boolean[] visited, int[] out) {
        if(depth == s.length/2){
            int start = 0;
            int link = 0;
            for(int i=0; i<visited.length; i++){
                for(int j=i+1; j<visited.length; j++){
                    if(visited[i] && visited[j]) start += s[i][j] + s[j][i];
                    if(!visited[i] && !visited[j]) link += s[i][j] + s[j][i];
                }
            }
            if(min > Math.abs(start - link)) min = Math.abs(start - link);
            return;
        }
        for(int i=0; i<s.length; i++){
            if(depth > 0 && out[depth-1] > i) continue;
            if(!visited[i]) {
                visited[i] = true;
                out[depth] = i;
                backtracking(s, depth + 1, visited, out);
                visited[i] = false;
            }
        }
    }
}