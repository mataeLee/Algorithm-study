import java.util.*;

public class Solution {
    // leetcode 78.Subsets

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(new ArrayList<>());

        for(int i=1; i<=nums.length; i++) {
            boolean[] visited = new boolean[nums.length];
            int[] out = new int[i];
            combinations(answer, nums, out, visited, nums.length, i, 0);
        }
        return answer;
    }

    public void combinations(List<List<Integer>> answer, int[] nums, int[] out, boolean[] visited, int n, int k, int depth) {
        if(depth == k){
            List<Integer> list = new ArrayList<>();
            for(int i=0; i<out.length; i++){
                list.add(out[i]);
            }
            answer.add(list);
            return;
        }

        for(int i=0; i<n; i++){
            if(depth > 0 && out[depth - 1] >= nums[i]) continue;
            if(!visited[i]){
                visited[i] = true;
                out[depth] = nums[i];
                combinations(answer, nums, out, visited, n, k, depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // make testcase

        int[] nums = {1, 2, 3};

        System.out.println(solution.subsets(nums));
    }
}