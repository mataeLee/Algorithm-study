import java.io.*;
import java.util.*;

public class Main{
    // 백준 백트래킹 N과 M(4) - 15652
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] out = new int[m];
        permutation(out, 0, n, m);
        System.out.println(sb.toString());
    }
    static void permutation(int[] out, int depth, int n, int m){
        if(depth==m){
            for(int i=0; i<out.length; i++){
                sb.append(out[i]);
                if(i<out.length-1) sb.append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=1; i<=n; i++){
            if(depth > 0 && out[depth-1] > i) continue;
            out[depth] = i;
            permutation(out, depth + 1, n, m);
        }
    }
}