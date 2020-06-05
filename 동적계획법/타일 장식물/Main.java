import java.util.*;

public class Main {
    // test case
    static int N = 5;

    // algorithm solution
    static class Solution {
        public long solution(int N) {
            long x=1;
            long y=1;
            for(int i=0; i<N-1; i++){
                long tmp = y;
                y = Math.max(x, y);
                x = x + tmp;
            }
            return 2*x + 2*y;
        }
    }

    // result
    public static void main(String[] args) {
        Solution solution = new Solution();
        long answer = solution.solution(N);
        System.out.println(answer);
    }
}