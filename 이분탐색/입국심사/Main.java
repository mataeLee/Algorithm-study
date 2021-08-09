import java.util.*;

public class Main {
    //test case
    static int[] times = {7, 10}; // 21, 3 2 1
    static int n = 6;

    //algorithm solution
    static class Solution {
        public long solution(int n, int[] times) {
            Arrays.sort(times);

            long right = (long)times[times.length-1] * (long)n;
            long left = 0;
            long mid, sum;
            long answer = right;
            while(left <= right){
                sum = 0;
                mid = (left + right)/2;
                for(int i=0; i<times.length; i++){
                    sum += mid/(long)times[i];
                    if(sum > n) break;
                }
                if(sum >= n) {
                    if(answer > mid)
                        answer = mid;
                    right = mid - 1;
                }
                else
                    left = mid + 1;
            }
            return answer;
        }
    }

    // result
    public static void main(String[] args) {
        Solution solution = new Solution();
        long answer = solution.solution(n, times);
        System.out.println(answer);
    }
}