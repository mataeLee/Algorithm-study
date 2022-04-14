import java.io.*;
import java.util.*;

public class Main{
    // 백준 분할정복 쿼드트리 - 1992
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<n; j++){
                map[i][j] = str.charAt(j)-'0';
            }
        }
        tree(map, n, 0, 0);
        System.out.println(sb);
    }

    static void tree(int[][] map, int n, int x, int y) {
        if(n == 0)return;
        if(!check(map, n, x, y)) {
            sb.append("(");
            tree(map, n / 2, x, y);
            tree(map, n / 2, x, y + n / 2);
            tree(map, n / 2, x + n / 2, y);
            tree(map, n / 2, x + n / 2, y + n / 2);
            sb.append(")");
        }
        else sb.append(map[x][y]);
    }

    private static boolean check(int[][] map, int n, int x, int y) {
        int val = map[x][y];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i+x][j+y] != val)
                    return false;
            }
        }
        return true;
    }
}