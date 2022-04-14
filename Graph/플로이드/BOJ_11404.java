import java.io.*;
import java.util.*;

public class Main {
    // 백준 그래프 플로이드 - 11404

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] distance = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++) if(i != j) distance[i][j] = Integer.MAX_VALUE/2;
        }

        for(int i=0; i<m; i++){
            String[] strs = br.readLine().split(" ");
            int a = Integer.parseInt(strs[0]) - 1;
            int b = Integer.parseInt(strs[1]) - 1;
            int c = Integer.parseInt(strs[2]);
            distance[a][b] = Math.min(distance[a][b], c);
        }
        for(int k=0; k<n; k++) { // 거처가는 지점
            for (int i = 0; i < n; i++) { // 출발지
                for (int j = 0; j < n; j++) { // 도착지
                    distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(distance[i][j] == Integer.MAX_VALUE/2) sb.append(0);
                else sb.append(distance[i][j]);
                if(j < n) sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}