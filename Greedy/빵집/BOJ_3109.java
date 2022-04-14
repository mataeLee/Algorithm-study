import java.io.*;
import java.util.*;

public class Main {
    // 백준 그리디 빵집 - 3109

    static int answer = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strs = br.readLine().split(" ");
        int R = Integer.parseInt(strs[0]);
        int C = Integer.parseInt(strs[1]);

        int[][] map = new int[R][C];

        for(int i=0; i<R; i++){
            String str = br.readLine();
            for(int j=0; j<C; j++){
                if(str.charAt(j) == 'x') {
                    map[i][j] = 1;
                }
            }
        }

        for(int i=0; i<R; i++){
            answer += dfs(i, 0, map);
        }
        System.out.println(answer);
    }

    static int dfs(int i, int j, int[][] map){
        if(i < 0 || i == map.length || j == map[0].length || map[i][j] == 1) return 0;
        map[i][j] = 1;
        if(j == map[0].length -1) return 1;
        if(dfs(i-1, j+1, map)>0) return 1;
        else if(dfs(i, j+1, map)>0) return 1;
        else if(dfs(i+1, j+1, map)>0) return 1;
        return 0;
    }
}