import java.io.*;
import java.util.*;

public class Main {
    // 백준 그래프 연구소 - 14502

    static int answer = 0;
    static List<Point> virus = new ArrayList<>();
    static class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");

        int n = Integer.parseInt(strs[0]);
        int m = Integer.parseInt(strs[1]);

        int[][] map = new int[n][m];
        for(int i=0; i<n; i++){
            strs = br.readLine().split(" ");
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(strs[j]);
                if(map[i][j] == 2){
                    virus.add(new Point(i, j));
                }
            }
        }
        broute_force(map, 0, n, m);
        System.out.println(answer);
    }

    static void broute_force(int[][] map, int level, int n, int m){
        if(level == 3){
            int[][] map2 = new int[n][m];
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(map[i][j] == 1)
                        map2[i][j] = map[i][j];
                }
            }
            for(Point p : virus){
                dfs(map2, n, m, p.x, p.y);
            }
            int count = 0;
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(map2[i][j] == 0) count++;
                }
            }
            if(answer < count) answer = count;
            return;
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j] == 0){
                    map[i][j] = 1;
                    broute_force(map, level+1, n, m);
                    map[i][j] = 0;
                }
            }
        }
    }

    static void dfs(int[][] map, int n, int m, int i, int j){
        if(i == -1 || j == -1 || i == n || j == m) return;
        if(map[i][j] != 0) return;
        map[i][j] = 2;
        dfs(map, n, m, i+1, j);
        dfs(map, n, m, i-1, j);
        dfs(map, n, m, i, j+1);
        dfs(map, n, m, i, j-1);
    }
}