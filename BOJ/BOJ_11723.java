import java.io.*;
import java.util.*;

public class Main {
    // 백준 비트마스크 집합 - 11723

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());

        int bit = 0;
        int val = 0;
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<M; i++){
            String[] strs = br.readLine().split(" ");
            switch (strs[0]){
                case "add":
                    val = Integer.parseInt(strs[1]);
                    bit |= (1 << (val-1));
                    break;
                case "remove":
                    val = Integer.parseInt(strs[1]);
                    bit &= ~(1 << (val-1));
                    break;
                case "check":
                    val = Integer.parseInt(strs[1]);
                    sb.append((bit & (1 << val-1)) != 0 ? 1 : 0);
                    sb.append("\n");
                    break;
                case "toggle":
                    val = Integer.parseInt(strs[1]);
                    bit ^= (1 << (val-1));
                    break;
                case "all":
                    bit |= (~0);
                    break;
                case "empty":
                    bit &= 0;
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}