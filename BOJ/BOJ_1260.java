import java.io.*;
import java.util.*;

public class Main {
    // 백준 DFS_BFS DFS와 BFS - 1260
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strs = br.readLine().split(" ");
        int n = Integer.parseInt(strs[0]);
        int m = Integer.parseInt(strs[1]);
        int v = Integer.parseInt(strs[2]);
        int[][] map = new int[n+1][n+1];

        for(int i=0; i<m; i++){
            strs = br.readLine().split(" ");
            int start = Integer.parseInt(strs[0]);
            int end = Integer.parseInt(strs[1]);
            map[start][end] = 1;
            map[end][start] = 1;
        }
        boolean[] visited = new boolean[n+1];
        dfs(map, v, visited);
        System.out.println();
        visited = new boolean[n+1];
        bfs(map, v, visited);
    }

    private static void bfs(int[][] map, int v, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;
        while (!queue.isEmpty()){
            int edge = queue.poll();
            System.out.print(edge + " ");
            for(int i=1; i<map.length; i++){
                if(!visited[i] && map[edge][i] == 1) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    private static void dfs(int[][] map, int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");
        for(int i=1; i<map.length; i++){
            if(!visited[i] && map[v][i] == 1){
                dfs(map, i, visited);
            }
        }
    }
}