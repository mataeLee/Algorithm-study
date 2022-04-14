import java.io.*;
import java.util.*;

public class Main {
    // 백준 그래프 네트워크 연결 - 1922

    static class Edge implements Comparable<Edge>{
        int start;
        int end;
        int cost;

        public Edge(int start, int end, int cost){
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge e){
            if(this.cost == e.cost) return this.start - e.start;
            return this.cost - e.cost;
        }
    }

    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int node_size = Integer.parseInt(br.readLine());
        int edge_size = Integer.parseInt(br.readLine());

        parent = new int[node_size+1];
        for(int i=0; i<node_size+1; i++){
            parent[i] = i;
        }

        PriorityQueue<Edge> queue = new PriorityQueue<>();

        for(int i=0; i<edge_size; i++){
            String[] strs = br.readLine().split(" ");
            queue.add(new Edge(Integer.parseInt(strs[0]), Integer.parseInt(strs[1]), Integer.parseInt(strs[2])));
        }

        int answer = 0;
        while (!queue.isEmpty()){
            Edge e = queue.poll();
            if(e.start == e.end) continue;
            int a = find(e.start);
            int b = find(e.end);

            if(a != b) {
                union(a, b);
                answer += e.cost;
            }
        }
        System.out.println(answer);
    }

    static int find(int a){
        if(parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

    static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a != b) parent[b] = a;
    }
}