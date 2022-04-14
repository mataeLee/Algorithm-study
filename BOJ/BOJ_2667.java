import java.io.*;
import java.util.*;

public class Main {
    // 백준 그래프 단지번호붙이기 - 2667
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];
        boolean[][] visited = new boolean[n][n];

        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(str.charAt(j)+"");
            }
        }

        List<Integer> houses = new ArrayList<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j] && map[i][j] == 1){
                    houses.add(dfs(map, visited, i, j));
                }
            }
        }
        Collections.sort(houses);
        System.out.println(houses.size());
        for(Integer val : houses){
            System.out.println(val);
        }
    }
    public static int dfs(int[][] map, boolean[][] visited, int i, int j){
        if(i == -1 || j == -1 || i == map.length || j == map.length || map[i][j] == 0 || visited[i][j]) return 0;
        visited[i][j] = true;
        return 1 + dfs(map, visited, i+1, j) +dfs(map, visited, i-1, j) +dfs(map, visited, i, j+1) +dfs(map, visited, i, j-1);
    }
}