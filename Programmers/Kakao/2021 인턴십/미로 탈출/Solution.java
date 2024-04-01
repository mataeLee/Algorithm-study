import leetcode.TreeNode;

import java.util.*;

public class Solution {
    // 프로그래머스 카카오 미로탈출

//    //test case
//    static int n = 4;
//    static int start = 1;
//    static int end = 4;
//    static int[][] roads = {{1, 2, 1}, {3, 2, 1}, {2, 4, 1}};
//    static int[] traps = {2, 3};

    static int n = 3;
    static int start = 1;
    static int end = 3;
    static int[][] roads = {{1, 2, 2}, {3, 2, 3}};
    static int[] traps = {2};

//    static int n = 5;
//    static int start = 1;
//    static int end = 5;
//    static int[][] roads = {{1, 2, 1}, {2, 3, 1}, {3, 2, 1}, {3, 5, 1}, {1, 5 ,10}};
//    static int[] traps = {3};

    //algorithm solution
    class Edge implements Comparable<Edge>{
        int v;
        int weight;
        int status;
        boolean dir;
        public Edge(int v, int weight, int status, boolean dir){
            this.v = v;
            this.weight = weight;
            this.status = status;
            this.dir = dir;
        }
        @Override
        public int compareTo(Edge o) {
            return Integer.compare(weight, o.weight);
        }
    }

    public int solution(int n, int start, int end, int[][] roads, int[] traps) {
        int INF = 100000000;

        // graph
        List<Edge>[] adj = new ArrayList[n+1];

        for(int i=1; i<n+1; i++){
            adj[i] = new ArrayList<>();
        }

        // traps
        Map<Integer, Integer> trap_map = new HashMap<>();
        for(int i=0; i<traps.length; i++) trap_map.put(traps[i], i);


        for(int i=0; i<roads.length; i++){
            int s = roads[i][0];
            int e = roads[i][1];
            int v = roads[i][2];
            // 정방향 역방향 간선 모두 저장
            adj[s].add(new Edge(e, v, 0, true));
            adj[e].add(new Edge(s, v, 0, false));
        }

        // dijkstra distance 배열, trap 총 개수^10의 그래프 상태에 따른 거리 저장 공간
        int[][] distance = new int[n+1][1<<10];

        // init
        for(int i=1; i<n+1; i++) {
            Arrays.fill(distance[i], INF);
        }

        // djikstra
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        queue.add(new Edge(start, 0, 0, true));

        int answer = INF;

        while (!queue.isEmpty()){
            Edge e = queue.poll();
            int cur_status = e.status;

            // 도착했으면 최단거리 갱신
            if(e.v == end) {
                answer = Math.min(answer, e.weight);
                continue;
            }

            // trap 상태 변경
            if(trap_map.containsKey(e.v)){
                cur_status ^= (1<<trap_map.get(e.v));
            }

            for(Edge next : adj[e.v]){
                int i = next.v;
                // 노드 from, to 모두 trap이 아닐 경우 기본 정방향
                boolean direction  = true;
                // 노드 둘다 trap일 경우 비트 연산을 통해 검증
                if(trap_map.containsKey(e.v) && trap_map.containsKey(i)){
                    int curBit = 1 << trap_map.get(e.v);
                    int nextBit = 1 << trap_map.get(i);
                    // true true or false false면 정방향 아니면 역방향
                    if(((curBit & cur_status) == curBit) != ((cur_status & nextBit) == nextBit)) direction = false;
                }
                // 노드 하나만 trap일 경우
                else if(trap_map.containsKey(e.v)){
                    direction = !((1<<trap_map.get(e.v) & cur_status) == 1<<trap_map.get(e.v));

                }
                else if(trap_map.containsKey(i)){
                    direction = !((1<<trap_map.get(i) & cur_status) == 1<<trap_map.get(i));
                }

                // 노드 상태에 따른 방향과 간선 방향 검증
                if(direction != next.dir) continue;

                // 최단거리 탐색
                if(distance[i][cur_status] > e.weight + next.weight){
                    distance[i][cur_status] = e.weight + next.weight;
                    queue.add(new Edge(i,e.weight + next.weight, cur_status, next.dir));
                }
            }
        }
        return answer;
    }

    // result
    public static void main(String[] args) {
        Solution solution = new Solution();
//        solution.solution();
//        TreeNode node = solution.solution();
//        System.out.println(solution.solution());
        System.out.println(Result.literal(solution.solution(n, start, end, roads, traps)));
//        System.out.println(Result.one_demension(solution.solution(places)));
//        System.out.println(Result.two_demension(solution.solution(dist)));
    }
}