import java.io.*;
import java.util.*;

public class Main {
    // 백준 그래프 알파벳 - 1987

    static int answer = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strs = br.readLine().split(" ");

        int R = Integer.parseInt(strs[0]);
        int C = Integer.parseInt(strs[1]);

        int[][] map = new int[R][C];
        for(int i=0; i<R; i++){
            String val = br.readLine();

            for(int j=0; j<C; j++){
                char c = val.charAt(j);
                map[i][j] = c;
            }
        }

        dfs(0, 0, map, R, C, "");

        System.out.println(answer);
    }

    static void dfs(int i, int j, int[][] map, int R, int C, String load){
        if(i == -1 || j == -1 || i == R || j == C || load.indexOf((char)map[i][j]) > -1) return;
        load += (char)map[i][j];
        if(answer < load.length()) answer = load.length();
        dfs(i+1, j, map, R, C, load);
        dfs(i, j+1, map, R, C, load);
        dfs(i-1, j, map, R, C, load);
        dfs(i, j-1, map, R, C, load);
    }
}