import java.util.*;

public class Main {
    //test case
    static int stock = 4;
    static int[] dates = {1, 2, 3, 4};
    static int[] supplies = {1, 1, 1, 1};
    static int k = 6;

    //algorithm solution
    static class Solution {
        public int solution(int stock, int[] dates, int[] supplies, int k) {
            int answer = 0;
            int date = 0;
            PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
            int [][] mem = new int[k+1][2];
            for(int i=0; i<dates.length; i++){
                mem[dates[i]][0] = 1;
                mem[dates[i]][1] = supplies[i];
            }
            while (date < k) {
                if(mem[date][0] == 1)
                    heap.add(mem[date][1]);
                if(stock == 0){
                    stock += heap.poll();
                    answer++;
                }
                stock--;
                date++;
            }
            return answer;
        }
    }
    // result
    public static void main(String[] args) {
        Solution solution = new Solution();
        int answer = solution.solution(stock, dates, supplies, k);
        System.out.println(answer);
    }
}