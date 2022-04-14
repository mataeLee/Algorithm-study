import java.io.*;
import java.util.*;

public class Main {
    // 백준 재귀 펙토리얼 - 10872
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] mem = new int[13];
        mem[0] = mem[1] = 1;
        System.out.println(recursive(n, mem));
    }
    static int recursive(int n, int[] mem) {
        if(mem[n] != 0) return mem[n];
        return mem[n] = recursive(n-1, mem)*n;
    }
}