import java.util.*;

public class Solution {
    // leetcode 77.Combinations

    public static List<List<Integer>> answer = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        boolean[] visited = new boolean[n];
        int[] out = new int[k];
        combinations(out, visited, n, k, 0);
        return answer;
    }

    public void combinations(int[] out, boolean[] visited, int n, int k, int depth) {
        if(depth == k){
            List<Integer> list = new ArrayList<>();
            for(int i=0; i<out.length; i++){
                list.add(out[i]);
            }
            answer.add(list);
            return;
        }

        for(int i=0; i<n; i++){
            if(depth > 0 && out[depth - 1] >= i+1) continue;

            if(!visited[i]){
                visited[i] = true;
                out[depth] = i+1;
                combinations(out, visited, n, k, depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // make testcase
        int n = 4;
        int k = 2;

        System.out.println(solution.combine(n, k));
    }
}