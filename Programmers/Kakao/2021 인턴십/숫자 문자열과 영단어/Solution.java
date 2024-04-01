import leetcode.TreeNode;

import java.util.*;

public class Solution {
    // 프로그래머스 카카오 숫자 문자열과 영단어
    //test case
    static String s = "one4seveneight";

    //algorithm solution
    public int solution(String s) {
        Map<String, Integer> num_map = new HashMap<>();
        num_map.put("zero" , 0);
        num_map.put("one" , 1);
        num_map.put("two" , 2);
        num_map.put("three" , 3);
        num_map.put("four" , 4);
        num_map.put("five" , 5);
        num_map.put("six" , 6);
        num_map.put("seven" , 7);
        num_map.put("eight" , 8);
        num_map.put("nine" , 9);

        StringBuilder sb = new StringBuilder();
        int pointer = 0;

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            String val = s.substring(pointer, i + 1);
            if (num_map.containsKey(val)) {
                sb.append(num_map.get(val));
                pointer = i + 1;
            }
            if (c > 47 && c < 58) {
                sb.append(c);
                pointer = i + 1;
            }
        }
        return Integer.parseInt(sb.toString());
    }

    // result
    public static void main(String[] args) {
        Solution solution = new Solution();
//        solution.solution();
//        TreeNode node = solution.solution();
//        System.out.println(solution.solution());
        System.out.println(Result.literal(solution.solution(s)));
//        System.out.println(Result.one_demension(solution.solution(id_list, report, k)));
//        System.out.println(Result.two_demension(solution.solution(dist)));
    }
}