import java.io.*;
import java.util.*;

public class Main{
    // 백준 백트래킹 n-quuen - 9663
    static int res = 0;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] cols = new int[n];
        recursive(n,0, cols);
        System.out.println(res);
    }

    private static void recursive(int n,  int depth, int[] cols) {
        if(depth == n){
            res++;
            return;
        }
        for(int i=0; i<n; i++) {
            cols[depth] = i;
            if(check(cols, depth))
                recursive(n, depth+1, cols);
        }
    }

    private static boolean check(int[] cols, int depth) {
        for(int i=0; i<depth; i++){
            // 직선
            if(cols[depth] == cols[i]) return false;
            // 대각선
            if(Math.abs(depth-i) == Math.abs(cols[depth] - cols[i])) return false;
        }
        return true;
    }
}