import java.io.*;
import java.util.*;

public class Main {
    // 백준 구현 날짜 계산 - 1476
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strs = br.readLine().split(" ");
        int max_a = Integer.parseInt(strs[0]);
        int max_b = Integer.parseInt(strs[1]);
        int max_c = Integer.parseInt(strs[2]);

        int a = 1;
        int b = 1;
        int c = 1;
        int answer = 1;
        while (true){
            if(a == 16) a = 1;
            if(b == 29) b = 1;
            if(c == 20) c = 1;
            if(a == max_a && b == max_b && c == max_c) break;
            a++;
            b++;
            c++;
            answer++;
        }
        System.out.println(answer);
    }
}