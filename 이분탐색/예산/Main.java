import java.util.*;

public class Main {
    //test case
    static int[] budgets = {120, 110, 140, 150};
    static int M = 485;

    //algorithm solution
    static class Solution {
        public int solution(int[] budgets, int M) {
            int answer = 0;
            Arrays.sort(budgets);
            int sum = 0;
            for(int i=0; i<budgets.length; i++){
                if(i == budgets.length-1) return budgets[i];
                if(M/(budgets.length-i) < budgets[i]) return M/(budgets.length-i);
                M -= budgets[i];
            }
            return 0;
        }
    }

    // result
    public static void main(String[] args) {
        Solution solution = new Solution();
        int answer = solution.solution(budgets, M);
        System.out.println(answer);
    }
}