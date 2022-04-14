import java.io.*;
import java.util.*;

public class Main {
    // 백준 피보나치 수 3 - 2749

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());

        if(n >= 1500000) n %= 1500000;

        long[] arr = new long[(int)n+1];
        arr[0] = 0;
        arr[1] = 1;
        for(int i=2; i<n+1; i++){
            arr[i] = (arr[i-1] + arr[i-2]) % 1000000;
        }

        System.out.println(arr[(int)n]);
    }
}