import java.io.*;
import java.util.*;

public class Main{
    // 백준 백트래킹 N과 M(3) - 15651
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[n+1];
        int[] out = new int[m];
        permutation(out, visited, 0, n, m);
        System.out.println(sb.toString());
    }
    static void permutation(int[] out, boolean[] visited, int depth, int n, int m){
        if(depth==m){
            for(int i=0; i<out.length; i++){
                sb.append(out[i]);
                if(i<out.length-1) sb.append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=1; i<=n; i++){
            out[depth] = i;
            permutation(out, visited, depth + 1, n, m);
        }
    }
}