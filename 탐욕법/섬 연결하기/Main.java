import java.util.*;

public class Main {
    // test case
    static int n = 4;
    static int[][] costs = {{0,1,1}, {0,2,2}, {1,2,5}, {1,3,1}, {2,3,8}}; // 4

    // algorithm solution
    static class Solution {
        class Node implements Comparable<Node>{
            public int v1;
            public int v2;
            public int cost;

            public Node(int v1, int v2, int cost) {
                this.v1 = v1;
                this.v2 = v2;
                this.cost = cost;
            }

            @Override
            public int compareTo(Node node) {
                if(this.cost > node.cost)
                    return 1;
                else if(this.cost == node.cost)
                    return 0;
                else
                    return -1;
            }
        }
        public int solution(int n, int[][] costs) {
            int answer = 0;

            List<Node> nodes = new ArrayList<>();

            int parent[] = new int[n];

            for(int i=0; i<n; i++){
                parent[i] = i;
            }

            for(int i=0; i<costs.length; i++){
                Node node = new Node(costs[i][0], costs[i][1], costs[i][2]);
                nodes.add(node);
            }
            Collections.sort(nodes);

            for(Node node: nodes){
                if(!find(node.v1, node.v2, parent)){
                    union(node.v1, node.v2, parent);
                    answer += node.cost;
                }
            }

            return answer;
        }

        public void union(int v1, int v2, int[] parent){
            v1 = getParent(v1, parent);
            v2 = getParent(v2, parent);

            if(v1 < v2) parent[v2] = v1;
            else parent[v1] = v2;
        }

        public boolean find(int v1, int v2, int[] parent) {
            v1 = getParent(v1, parent);
            v2 = getParent(v2, parent);
            // 두 정점의 부모 정점이 일치하면 연결되어 있는 것이고, 아니면 연결되어 있지 않은 것이다.
            if (v1 == v2) return true;
            else return false;
        }

        public int getParent(int v1, int[] parent) {
            if(parent[v1] == v1) return v1; // 자기 자신이 부모일 경우
            return parent[v1] = getParent(parent[v1], parent);
        }
    }

    // result
    public static void main(String[] args) {
        Solution solution = new Solution();
        int answer = solution.solution(n, costs);
        System.out.println(answer);
    }
}