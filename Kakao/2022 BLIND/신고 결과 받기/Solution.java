import leetcode.TreeNode;

import java.util.*;

public class Solution {
    // 프로그래머스 카카오 신고 결과 받기
    //test case
    static String[] id_list = {"muzi", "frodo", "apeach", "neo"};
    static String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
    static int k = 2;

    //algorithm solution
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        Map<String, Set<String>> reports = new HashMap<>();
        Map<String, Set<String>> reported = new HashMap<>();

        for(int i=0; i<report.length; i++){
            String[] contents = report[i].split(" ");
            String a = contents[0];
            String b = contents[1];

            if(!reports.containsKey(a)){
                Set<String> val = new HashSet<>();
                val.add(b);
                reports.put(a, val);
            }
            else{
                reports.get(a).add(b);
            }
            if(!reported.containsKey(b)){
                Set<String> val = new HashSet<>();
                val.add(a);
                reported.put(b, val);
            }
            else{
                reported.get(b).add(a);
            }
        }

        for(int i=0; i<id_list.length; i++){
            String id = id_list[i];
            if(!reports.containsKey(id)) {
                answer[i] = 0;
                continue;
            }
            Set<String> set = reports.get(id);
            int res = 0;
            for(String str : set){
                if(reported.containsKey(str) && reported.get(str).size() >= k) res++;
            }
            answer[i] = res;
        }
        return answer;
    }

    // result
    public static void main(String[] args) {
        Solution solution = new Solution();
//        solution.solution();
//        TreeNode node = solution.solution();
//        System.out.println(solution.solution());
//        System.out.println(Result.literal(solution.solution(grid)));
        System.out.println(Result.one_demension(solution.solution(id_list, report, k)));
//        System.out.println(Result.two_demension(solution.solution(dist)));
    }
}