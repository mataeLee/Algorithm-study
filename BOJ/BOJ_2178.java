import java.io.*;
import java.util.*;

public class Main {
    // 백준 그래프 미로 탐색 - 2178
    static int answer = 0;
    static class Point{
        int x;
        int y;
        Point(int x, int y){
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
        boolean[][] visited = new boolean[n][m];
        int[][] distance = new int[n][m];
        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<str.length(); j++){
                int a = str.charAt(j) - '0';
                if(a == 0) visited[i][j] = true;
                map[i][j] = a;
            }
        }
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0));
        distance[0][0] = 1;
        visited[0][0] = true;
        while (!queue.isEmpty()){
            Point p = queue.poll();
            int i = p.x;
            int j = p.y;
            if(i == n-1 && j == m-1) break;
            // 북
            if(i > 0 && !visited[i-1][j]){
                queue.add(new Point(i-1,j));
                visited[i-1][j] = true;
                distance[i-1][j] = distance[i][j]+1;
            }
            // 동
            if(j < m-1 && !visited[i][j+1]){
                queue.add(new Point(i,j+1));
                visited[i][j+1] = true;
                distance[i][j+1] = distance[i][j]+1;
            }
            // 남
            if(i < n-1 && !visited[i+1][j]){
                queue.add(new Point(i+1, j));
                visited[i+1][j] = true;
                distance[i+1][j] = distance[i][j]+1;
            }
            // 서
            if(j > 0 && !visited[i][j-1]){
                queue.add(new Point(i,j-1));
                visited[i][j-1] = true;
                distance[i][j-1] = distance[i][j]+1;
            }
        }
        System.out.println(distance[n-1][m-1]);
    }
}