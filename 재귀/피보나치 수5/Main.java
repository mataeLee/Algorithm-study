import java.io.*;
import java.util.*;

public class Main {
    // 백준 재귀 피보나치 수 5 - 10870
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(recursive(n));
    }
    static int recursive(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        return recursive(n-1)+recursive(n-2);
    }
}