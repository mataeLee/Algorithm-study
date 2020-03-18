import java.util.*;
public class Main {

    // test case
    static int [] array = {1, 5, 2, 6, 3, 7, 4};
    static int [][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

    // algorithm solution
    static class Solution {
        public int[] solution(int[] array, int[][] commands) {
            int[] answer = {};

            List<Integer> answers = new ArrayList<>();

            for(int i=0; i<commands.length; i++){
                List<Integer> queue = new ArrayList<>();
                int a = commands[i][0];
                int b = commands[i][1];
                int k = commands[i][2];

                for(int j=a-1; j<b; j++){
                    queue.add(array[j]);
                }
                Collections.sort(queue);
                answers.add(queue.get(k-1));
            }
            answer = new int[answers.size()];
            for(int i=0; i<answers.size(); i++){
                answer[i] = answers.get(i);
            }
            return answer;
        }
    }

    // result
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] answer = solution.solution(array, commands);
        for(int i=0; i<answer.length; i++){
            System.out.println(answer[i] + ", ");
        }
    }
}