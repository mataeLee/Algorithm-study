import java.util.*;

public class Main {
    // test case

//    static int[] progresses = {93, 30, 55};
//    static int[] speeds = {1, 30, 5};

//    static int[] progresses = {40, 93, 30, 55, 60, 65};
//    static int[] speeds = {60, 1, 30, 5 , 10, 7};

//    static int[] progresses = {93, 30, 55, 60, 40, 65};
//    static int[] speeds = {1, 30, 5 , 10, 60, 7};

    static int[] progresses = {93, 60, 70};
    static int[] speeds = {2, 10, 50};


    // algorithm solution
    static class Solution {
        public int[] solution(int[] progresses, int[] speeds) {

            List<Integer> answers = new ArrayList<>();
            int max = (100 - progresses[0]) / speeds[0];
            int cnt = 0;
            for(int i=0; i<progresses.length; i++){
                int remain = ((100 - progresses[i]) % speeds[i] == 0) ? (100 - progresses[i]) / speeds[i] : (100 - progresses[i]) / speeds[i] + 1;
                if(max < remain) {
                    max = remain;
                    if(cnt != 0)
                        answers.add(cnt);
                    cnt = 1;
                }
                else{
                    cnt++;
                }
            }
            answers.add(cnt);

            int [] answer = new int[answers.size()];
            for(int i=0; i<answers.size(); i++){
                answer[i] = answers.get(i);
            }
            return answer;
        }
    }

    // result
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] answer = solution.solution(progresses, speeds);
        System.out.println(answer);
    }

}
