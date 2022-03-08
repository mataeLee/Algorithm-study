import java.io.*;
import java.util.*;

public class Main {
    // 백준 그래프 줄세우기 - 2252

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        int n = Integer.parseInt(strs[0]);
        int m = Integer.parseInt(strs[1]);

        int[] in = new int[n+1];
        Queue<Integer>[] list = new Queue[n+1];
        for(int i=1; i<n+1; i++){
            list[i] = new LinkedList<>();
        }

        for(int i=0; i<m; i++){
            strs = br.readLine().split(" ");
            int a = Integer.parseInt(strs[0]);
            int b = Integer.parseInt(strs[1]);
            list[a].add(b);
            in[b]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<n+1; i++){
            if(in[i] == 0) queue.add(i);
        }

        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()){
            int node = queue.poll();
            sb.append(node).append(" ");
            for(int val : list[node]){
                in[val]--;

                if(in[val] == 0) queue.add(val);
            }
        }
        System.out.println(sb.toString());
    }
}