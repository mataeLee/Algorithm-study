import java.io.*;
import java.util.*;

public class Main{
    // 백준 그리디 ATM - 11399
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] strs = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(strs[i]);
        }
        Arrays.sort(arr);
        int res = 0;
        for(int i=0; i<arr.length; i++){
            int sum = arr[i];
            for(int j=i-1; j>=0; j--){
                sum += arr[j];
            }
            res += sum;
        }
        System.out.println(res);
    }
}