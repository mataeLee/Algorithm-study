import java.io.*;
import java.util.*;

public class Main{
    // 백준 자료구조 요세푸스 문제 - 1158
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(strs[0]);
        int k = Integer.parseInt(strs[1]);

        List<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            list.add(i+1);
        }
        int idx = 0;
        sb.append("<");
        while(!list.isEmpty()){
            idx = (idx+k-1) % n;
            sb.append(list.get(idx));
            list.remove(idx);
            n--;
            if(list.size() > 0) sb.append(", ");
        }
        sb.append(">");
        System.out.println(sb);
    }
}