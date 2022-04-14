import java.io.*;
import java.util.*;

public class Main {
    // 백준 파티 - 1238

    static class Edge implements Comparable<Edge>{
        int des;
        int cost;

        public Edge(int des, int cost){
            this.des = des;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strs = br.readLine().split(" ");
        int N = Integer.parseInt(strs[0]);
        int M = Integer.parseInt(strs[1]);
        int X = Integer.parseInt(strs[2]);

        List<Edge>[] list = new ArrayList[N+1];
        List<Edge>[] rList = new ArrayList[N+1];

        for(int i=1; i<N+1; i++) {
            list[i] = new ArrayList<>();
            rList[i] = new ArrayList<>();
        }

        int INF = 1000 * (N+1); // 경로 최댓값

        for(int i=0; i<M; i++){
            strs = br.readLine().split(" ");
            int a = Integer.parseInt(strs[0]);
            int b = Integer.parseInt(strs[1]);
            int c = Integer.parseInt(strs[2]);

            list[a].add(new Edge(b, c));
            rList[b].add(new Edge(a, c));
        }

        int[] distance = new int[N+1];
        int[] distance2 = new int[N+1];
        boolean[] visited = new boolean[N+1];

        for(int i=1; i<N+1; i++) distance[i] = distance2[i] = INF;

        PriorityQueue<Edge> heap = new PriorityQueue<>();
        heap.add(new Edge(X, 0));
        distance[X] = 0;

        while (!heap.isEmpty()){
            Edge e = heap.poll();
            int des = e.des;

            if(visited[des]) continue;
            visited[des] = true;

            for(Edge it : list[des]){
                if(distance[des] + it.cost < distance[it.des]) {
                    distance[it.des] = distance[des] + it.cost;
                    heap.add(new Edge(it.des, distance[it.des]));
                }
            }
        }


        visited = new boolean[N+1];
        heap = new PriorityQueue<>();
        heap.add(new Edge(X, 0));
        distance2[X] = 0;

        while (!heap.isEmpty()){
            Edge e = heap.poll();
            int des = e.des;

            if(visited[des]) continue;
            visited[des] = true;

            for(Edge it : rList[des]){
                if(distance2[des] + it.cost < distance2[it.des]) {
                    distance2[it.des] = distance2[des] + it.cost;
                    heap.add(new Edge(it.des, distance2[it.des]));
                }
            }
        }

        int answer = 0;
        for(int i=1; i<N+1; i++){
            if(distance[i] + distance2[i] > answer) answer = distance[i] + distance2[i];
        }
        System.out.println(answer);
    }
}