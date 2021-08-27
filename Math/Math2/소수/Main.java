import java.io.*;
import java.util.*;

public class Main {
    // 백준 기본수학2 소수 - 2581
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        for(int i=m; i<=n; i++){
            if(check(i))list.add(i);
        }

        if(list.size() == 0) System.out.println(-1);
        else {
            int sum = 0;
            for(int i=0; i<list.size(); i++){
                sum += list.get(i);
            }
            System.out.println(sum);
            System.out.println(list.get(0));
        }
    }
    static boolean check(int num){
        if(num == 1) return false;
        for(int i=2; i<num; i++){
            if(num%i == 0) return false;
        }
        return true;
    }
}