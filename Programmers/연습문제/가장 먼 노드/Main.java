import java.util.*;

public class Main {
    // 프로그래머스 Lv.3 가장 먼 노드

    //test case
    static int n = 6; // 2~ 20000
    static int[][] vertax = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}}; // 1~50000

    //algorithm solution
    static class Solution {
        public int solution(int n, int[][] edge) {
            int answer = 0;
            int[] distance = new int[n+1]; // 0 정점은 없음
            boolean[] visited = new boolean[n+1];

            visited[0] = true;
            HashSet<Integer>[] set = new HashSet[n+1];
            for(int i=0; i<n+1; i++){
                set[i] = new HashSet<>();
                if(i>=2) distance[i] = Integer.MAX_VALUE;
            }
            for(int i=0; i<edge.length; i++){
                int n1 = edge[i][0];
                int n2 = edge[i][1];
                set[n1].add(n2);
                set[n2].add(n1);
            }
            Queue<Integer> queue = new LinkedList<>();
            queue.add(1);
            while(queue.size() > 0){
                int node = queue.poll();
                visited[node] = true;

                Iterator it = set[node].iterator();

                while (it.hasNext()){
                    int node2 = (int) it.next();
                    if(visited[node2] == false && distance[node2] > distance[node] + 1){
                        queue.add(node2);
                        distance[node2] = distance[node] + 1;
                    }
                }
            }
            int max = 0;
            for(int i=2; i<distance.length; i++){
                if(distance[i] > max) {
                    max = distance[i];
                    answer = 1;
                }
                else if(distance[i] == max){
                    answer++;
                }
            }
            return answer;
        }
    }

    // result
    public static void main(String[] args) {
        Solution solution = new Solution();
        int answer = solution.solution(n, vertax);
//        System.out.print("[");
//        for(int i=0; i<answer.length; i++){
//            System.out.print(answer[i]);
//            if(i < answer.length - 1) System.out.print(", ");
//        }
//      System.out.print("]");
        System.out.println(answer);
    }
}