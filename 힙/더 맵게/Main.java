import java.util.*;

public class Main {
    //test case
    static int[] scoville = {1, 2, 3, 9, 10, 12};
    static int K = 7;
//    static int[] scoville = {0,0,2};
//    static int K = 2;

    //algorithm solution
    static class Solution {
        public int solution(int[] scoville, int K) {
            int answer = 0;

            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
            for(int i=0; i<scoville.length; i++){
                priorityQueue.add(scoville[i]);
            }

            while(priorityQueue.size() > 1){
                if(priorityQueue.peek() >= K ) return answer;
                int num1 = priorityQueue.poll();
                int num2 = priorityQueue.poll();

                int sum = num1 + (num2*2);
                priorityQueue.add(sum);
                answer++;
            }
            if(priorityQueue.peek() >= K ) return answer;
            return -1;
        }
    }

    // result
    public static void main(String[] args) {
        Solution solution = new Solution();
        int answer = solution.solution(scoville, K);
        System.out.println(answer);
    }
}