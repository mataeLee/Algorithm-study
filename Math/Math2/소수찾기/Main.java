import java.io.*;
import java.util.*;

public class Main {
    // 백준 기본수학2 소수찾기 - 1978
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        int cnt = 0;
        String[] arr = br.readLine().split(" ");
        for(int i=0; i<arr.length; i++){
            int n = Integer.parseInt(arr[i]);
            if(check(n)) cnt++;
        }
        System.out.println(cnt);
    }
    static boolean check(int num){
        if(num == 1) return false;
        for(int i=2; i<num; i++){
            if(num%i == 0) return false;
        }
        return true;
    }
}