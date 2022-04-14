import java.io.*;
import java.util.*;

public class Main {
    // 백준 기본수학1 분수찾기 - 1193
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double n = Integer.parseInt(br.readLine());
        boolean dir = false;
        double sum = 0;
        double cnt = 1;
        while(sum < n){
            sum += cnt++;
            dir = !dir;
        }
        cnt--;
        sum = sum - cnt + 1;
        if(dir){ // cnt, 1
            System.out.println((int)(cnt - (n-sum)) + "/" + (int)(1 + (n-sum)));
        }
        else { // 1, cnt
            System.out.println((int)(1 + (n-sum)) + "/" + (int)(cnt - (n-sum)));
        }
    }
}