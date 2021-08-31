import java.io.*;
import java.util.*;

public class Main{
    // 백준 분할정복 색종이 만들기 - 2630
    static int blue = 0;
    static int white = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        for(int i=0; i<n; i++){
            String[] strs = br.readLine().split(" ");
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(strs[j]);
            }
        }
        cut(map, n, 0, 0);
        System.out.print(white+"\n"+blue);
    }

    static void cut(int[][] map, int n, int x, int y) {
        if(n == 0)return;
        if(!check(map, n, x, y)) {
            cut(map, n / 2, x, y);
            cut(map, n / 2, x + n / 2, y);
            cut(map, n / 2, x, y + n / 2);
            cut(map, n / 2, x + n / 2, y + n / 2);
        }
    }

    private static boolean check(int[][] map, int n, int x, int y) {
        int val = map[x][y];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i+x][j+y] != val)
                    return false;
            }
        }
        if(val == 1) blue++;
        else white++;
        return true;
    }
}