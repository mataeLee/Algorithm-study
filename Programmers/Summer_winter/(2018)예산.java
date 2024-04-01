import java.util.*;

public class Main {
    //test case
    static int[] budgets = {1, 1, 1, 1000};
    static int M = 900;

    //algorithm solution
    static class Solution {
        public int solution(int[] budgets, int M) {
            int answer = 0;
            Arrays.sort(budgets);
            int sum = 0;
            for(int i=0; i<budgets.length; i++){
                if(i == budgets.length-1) return (budgets[i] < M)? budgets[i] : M;
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