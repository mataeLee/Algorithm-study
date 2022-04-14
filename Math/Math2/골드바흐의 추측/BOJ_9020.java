import java.io.*;
import java.util.*;

public class Main {
    // 백준 기본수학2 골드바흐의 추측 - 9020
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] prime = new boolean[10001];
        prime[0] = prime[1] = true;
        for(int i=2; i<=Math.sqrt(10000); i++){
            if(prime[i] == true) continue;
            for(int j=i*i;j<=10000;j+=i){
                prime[j] = true;
            }
        }
        for(int i=0; i<n; i++){
            int m = Integer.parseInt(br.readLine());
            int a = m/2;
            int b = m/2;
            while (true){
                if(prime[a]) {
                    a--;
                    continue;
                }
                if(prime[b]) {
                    b++;
                    continue;
                }
                if(a+b == m){
                    System.out.println(a + " " + b);
                    break;
                }
                else if(a+b > m){
                    a--;
                }
                else {
                    b++;
                }
            }
        }
    }
}