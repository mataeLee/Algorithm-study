public class Main {

    // test case
    static int [] heights = {3,9,9,3,5,7,2};

    // algorithm solution
    static class Solution {
        public int[] solution(int[] heights) {
            int[] answer = new int[heights.length];

            for(int i=0; i<heights.length; i++){
                for(int j=i; j>=0; j--){
                    if(heights[i] < heights[j]){
                        answer[i] = j+1;
                        break;
                    }
                }
            }
            return answer;
        }
    }

    // result
    public static void main(String[] args) {
        Solution solution = new Solution();
        int [] answer = solution.solution(heights);
        for(int i=0; i<answer.length; i++){
            System.out.print(answer[i] + ", ");
        }
    }
}