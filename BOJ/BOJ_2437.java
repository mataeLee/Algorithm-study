import java.io.*;
import java.util.*;

public class Main {
    // 백준 그리디 저울 - 2437

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] strs = br.readLine().split(" ");
        int[] weights = new int[n];
        for(int i=0; i<n; i++){
            weights[i] = Integer.parseInt(strs[i]);
        }

        Arrays.sort(weights);
        int sum = 0;
        for(int i=0; i<n; i++){
            if(sum + 1 < weights[i]) break;
            sum += weights[i];
        }
        System.out.println(sum+1);
    }
}