import java.io.*;
import java.util.*;

public class Main {
    // 백준 기본수학2 소수구하기 - 1929
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        boolean[] mem = new boolean[n+1];
        mem[1] = mem[0] = true;
        for(int i=2; i<=Math.sqrt(n); i++){
            if(mem[i] == true) continue;
            for(int j=i*i;j<=n;j+=i){
                mem[j] = true;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=m; i<=n; i++){
            if(!mem[i])
                sb.append(i).append("\n");
        }
        System.out.println(sb.toString());
    }
}