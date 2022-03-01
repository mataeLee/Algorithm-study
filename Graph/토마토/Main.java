import java.io.*;
import java.util.*;

public class Main {
    // 백준 그래프 토마토 - 7576
    static class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int[][] dir = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        int m = Integer.parseInt(strs[0]);
        int n = Integer.parseInt(strs[1]);

        int[][] map = new int[n][m];

        Queue<Point> queue = new LinkedList<>();

        for(int i=0; i<n; i++){
            strs = br.readLine().split(" ");
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(strs[j]);
                if(map[i][j] == 1)
                    queue.add(new Point(i, j));
            }
        }

        int day = -1;

        while (queue.size() > 0){
            int len = queue.size();
            for(int j=0; j<len; j++) {
                Point p = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int x = p.x + dir[i][0];
                    int y = p.y + dir[i][1];
                    if (x == -1 || y == -1 || x == n || y == m || map[x][y] != 0) continue;
                    queue.add(new Point(x, y));
                    map[x][y] = 1;
                }
            }
            day++;
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j] == 0){
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(day);
    }
}