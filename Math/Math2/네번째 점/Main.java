import java.io.*;
import java.util.*;

public class Main {
    // 백준 기본수학2 네 번째 점 - 3009
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] x = new int[3];
        int[] y = new int[3];
        int[] memX = new int[1001];
        int[] memY = new int[1001];
        for(int i=0; i<3; i++){
            String[] arr = br.readLine().split(" ");
            x[i] = Integer.parseInt(arr[0]);
            y[i] = Integer.parseInt(arr[1]);
            memX[x[i]]++;
            memY[y[i]]++;
        }
        int resX = 0;
        int resY = 0;
        for(int i=0; i<3; i++){
            if(memX[x[i]] % 2 == 1) resX = x[i];
            if(memY[y[i]] % 2 == 1) resY = y[i];
        }
        System.out.println(resX + " " + resY);
    }
}