import java.io.*;
import java.util.*;

public class Main {
    // 백준 기본수학1 부녀회장이 될테야 - 2775
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[][] map = new int[16][16]; // 0, 0은 배재
        for(int i=1; i<map.length;i++){
            map[0][i] = 1; // 0층
            map[i][1] = 1; // 1호
        }
        for(int i=0; i<num; i++){
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            System.out.println(recursive(k+1, n, map));
        }
    }
    public static int recursive(int i, int j, int map[][]){
        if(map[i][j] != 0) return map[i][j];
        if(i<1 || j<1) return 0;
        return map[i][j] = recursive(i-1, j, map) + recursive(i, j-1, map);
    }
}