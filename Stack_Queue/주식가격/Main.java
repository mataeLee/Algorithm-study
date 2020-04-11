import java.util.*;

public class Main {
    // test case

    static int [] prices = {1, 2, 3, 2, 3};
//    static int [] prices = {5, 6, 2, 4, 7, 1, 3};

    // algorithm solution
    static class Solution {

        public int[] solution(int[] prices) {
            int[] answer = new int[prices.length];

            for(int i=0; i<prices.length; i++){
                int price = prices[i];
                for (int j=i; j<prices.length; j++){
                    if(price > prices[j]){
                        answer[i] = j-i;
                        break;
                    }
                }
                if(answer[i] == 0)
                    answer[i] = prices.length - i - 1;
            }
            return answer;
        }
    }

    // result
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] answer = solution.solution(prices);
        System.out.println(answer);
    }

}
