import leetcode.TreeNode;

import java.util.*;

public class Solution {
    // 프로그래머스 카카오 보석 쇼핑
    // 4:07

    //test case
    static String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA", "RUBY"};

    //algorithm solution

    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        answer[0] = 0;
        answer[1] = gems.length;

        Set<String> gem_set = new HashSet<>();
        for(int i=0; i<gems.length; i++) if(!gem_set.contains(gems[i])) gem_set.add(gems[i]);

        Map<String, Integer> map = new HashMap<>();

        int start = 0;

        for(int i=0; i<gems.length; i++){
            String gem = gems[i];

            // 보유한 보석중 가장 뒤의 인덱스 저장
            map.put(gem, i);

            // start 포인터 변경
            if(i > start && gem.equals(gems[start])) {
                while (map.get(gems[start]) != start) {
                    start++;
                }
            }
            if(map.size() == gem_set.size()){
                int len = i - start;

                if(len < answer[1]- answer[0]){
                    answer[0] = start+1;
                    answer[1] = i+1;
                }
            }
        }
        return answer;
    }

    // result
    public static void main(String[] args) {
        Solution solution = new Solution();
//        solution.solution();
//        TreeNode node = solution.solution();
//        System.out.println(solution.solution());
//        System.out.println(Result.literal(solution.solution(gems)));
        System.out.println(Result.one_demension(solution.solution(gems)));
//        System.out.println(Result.two_demension(solution.solution(dist)));
    }
}