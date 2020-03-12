import java.util.*;
public class Main {

    // test case
    static int n = 5;
    static int [] lost = {2, 4};
    static int [] reverse = {1, 3, 5};

    static class Solution {
        public int solution(int n, int[] lost, int[] reserve) {
            int answer = n;

            for(int i=0 ;i<lost.length; i++){
                for(int j=0; j<reserve.length; j++){
                    if(reserve[j] == lost[i]){
                        lost[i] = -1;
                        reserve[j] = -1;
                        break;
                    }
                }
            }
            for(int i=0 ;i<lost.length; i++){
                for(int j=0; j<reserve.length; j++){
                    if(reserve[j] == lost[i]+1){
                        lost[i] = -1;
                        reserve[j] = -1;
                        break;
                    }
                    if(reserve[j] == lost[i]-1){
                        lost[i] = -1;
                        reserve[j] = -1;
                        break;
                    }
                }
            }
            for(int i=0; i<lost.length; i++){
                if(lost[i] != -1)
                    answer--;
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(n, lost, reverse));
    }
}