import java.io.*;
import java.util.*;

public class Main{
    // 백준 자료구조 문제집 - 1766 4

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        String[] strs = br.readLine().split(" ");
        int n = Integer.parseInt(strs[0]);
        int m = Integer.parseInt(strs[1]);
        PriorityQueue<Integer>[] arr = new PriorityQueue[n+1];

        for(int i=1; i<n+1; i++){
            arr[i] = new PriorityQueue<>();
        }

        for(int i=0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[b].add(a);
        }

        List<Integer> res = new ArrayList<>();
        for(int i=1; i<n+1; i++){
            if(arr[i] == null) continue;
            while (arr[i].size() > 0){
                int val = arr[i].poll();
                res.add(val);
                arr[val] = null;
            }
            res.add(i);
            arr[i] = null;
        }
        for(int i=0; i<res.size(); i++){
            sb.append(res.get(i));
            if(i < res.size()-1) sb.append(" ");
        }
        System.out.print(sb);
    }
}