import java.io.*;
import java.util.*;

public class Main {
    // 백준 자료구조 친구 네트워크 - 4195

    static int[] parent;
    static int[] rank;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strs = br.readLine().split(" ");

        int n = Integer.parseInt(strs[0]);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            int m = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            parent = new int[m*2+1];
            rank = new int[m*2+1];
            for(int j=0; j<parent.length; j++){
                parent[j] = j;
                rank[j] = 1;
            }
            int idx = 0;

            for(int j=0; j<m; j++){
                strs = br.readLine().split(" ");
                if(!map.containsKey(strs[0])){
                    map.put(strs[0], idx);
                    idx++;
                }
                if(!map.containsKey(strs[1])){
                    map.put(strs[1], idx);
                    idx++;
                }
                union(map.get(strs[0]), map.get(strs[1]));
                sb.append(rank[find(map.get(strs[0]))]).append("\n");
            }
        }

        System.out.println(sb);
    }
    static int find(int a){
        if(parent[a] == a) return a;
        return parent[a] = find(parent[a]); // path compress
    }
    static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a != b) {
            parent[b] = a;
            rank[a] += rank[b];
            rank[b] = 0;
        }
    }
}