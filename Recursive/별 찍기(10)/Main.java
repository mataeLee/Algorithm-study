import java.io.*;
import java.util.*;

public class Main {
    // 백준 재귀 별 찍기(10) - 2447
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] mem = new char[n][n];
        for(int i=0; i<mem.length; i++){
            Arrays.fill(mem[i], ' ');
        }
        recursive(n, mem, 0, 0);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<mem.length; i++){
            sb.append(mem[i]);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    static void recursive(int n, char[][] mem, int x, int y) {
        if (n < 2) return;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i != 1 || j != 1) {
                    recursive(n / 3, mem, x + i * n / 3, y + j * n / 3);
                    mem[i + x][j + y] = '*';
                }
            }
        }
    }
}