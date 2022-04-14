import java.io.*;
import java.util.*;

public class Main {
    // 백준 기본수학2 베르트랑 공준 - 4948
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] mem = new int[2*123456+1];
        for(int i=2; i<mem.length; i++) mem[i] = i;
        for(int i=2; i<mem.length; i++){
            if(mem[i] == 0) continue;
            for(int j=i+i;j<=mem.length;j+=i){
                mem[j] = 0;
            }
        }
        while (true){
            int n = Integer.parseInt(br.readLine());
            if(n == 0) return;
            int cnt = 0;
            for(int i=n+1; i<=2*n; i++){
                if(mem[i] != 0) cnt++;
            }
            System.out.println(cnt);
        }
    }
}