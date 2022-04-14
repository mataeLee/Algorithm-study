import java.io.*;
import java.util.*;

public class Main {
    // 백준 하노이 탑 이동 순서  - 11729
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        recursive(n, 1, 3, sb);
        sb.insert(0, cnt+"\n");
        System.out.println(sb.toString());
    }
    static void recursive(int n, int a, int b, StringBuilder sb) {
        if(n <= 1){
            cnt++;
            sb.append(a).append(" ").append(b).append("\n");
        }
        else{
            int c = 6-a-b; // 거쳐가는 기둥

            recursive(n-1,a,c,sb);
            cnt++;
            sb.append(a).append(" ").append(b).append("\n");
            recursive(n-1,c, b,sb);
        }
    }
}