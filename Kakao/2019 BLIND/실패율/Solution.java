import leetcode.TreeNode;

import java.util.*;

public class Solution {
    // 프로그래머스 카카오 실패율

    //test case
    static int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
    static int N = 5;

    //algorithm solution
    class Failure{
        int stage;
        double failure;
        public Failure(int stage, double failure){
            this.stage = stage;
            this.failure = failure;
        }
    }
    public int[] solution(int N, int[] stages) {
        int[] finish = new int[N+1];
        int[] ing = new int[N+2];

        for(int i=0; i<stages.length; i++){
            ing[stages[i]]++;
        }

        int count = 0;
        for(int i=ing.length-1; i>=0; i--){
            count += ing[i];
            if(i > 0) finish[i-1] = count;
        }

        List<Failure> list = new ArrayList<>();

        for(int i=1; i < finish.length; i++){
            if(finish[i-1] == 0) list.add(new Failure(i, 0));
            else list.add(new Failure(i,  ((double)ing[i] / finish[i-1]) * 100));
        }

        Collections.sort(list, ((o1, o2) -> Double.compare(o2.failure, o1.failure)));

        int[] answer = new int[N];
        for(int i=0; i<N; i++) answer[i] = list.get(i).stage;
        return answer;
    }

    // result
    public static void main(String[] args) {
        Solution solution = new Solution();
//        solution.solution();
//        TreeNode node = solution.solution();
//        System.out.println(solution.solution());
//        System.out.println(Result.literal(solution.solution(numbers, hand)));
        System.out.println(Result.one_demension(solution.solution(N, stages)));
//        System.out.println(Result.two_demension(solution.solution(dist)));
    }
}