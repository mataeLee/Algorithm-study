import java.io.*;
import java.util.*;

public class Main{
    // 백준 분할정복 곱셈 - 1629
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        int a = Integer.parseInt(strs[0]);
        int b = Integer.parseInt(strs[1]);
        int c = Integer.parseInt(strs[2]);
        System.out.println(pow(a, b, c));
    }

    static long pow(int a, int b, int c) {
        if(b==0) return 1;
        long val = pow(a, b/2, c);
        val = val * val % c;
        if(b%2==1) return val*a%c;
        else return val;
    }
}