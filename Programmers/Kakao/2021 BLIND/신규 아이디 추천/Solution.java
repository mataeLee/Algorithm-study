import leetcode.TreeNode;

import java.util.*;

public class Solution {
    // 프로그래머스 카카오 신규 아이디 추천
    //test case
    static String new_id = "123_.def";

    //algorithm solution
    public String solution(String new_id) {
        new_id = new_id.toLowerCase();

        StringBuilder sb = new StringBuilder();

        boolean dot = false;

        for(int i=0; i<new_id.length(); i++){
            char c = new_id.charAt(i);
            if(c == '.'){
                if(!dot){
                    sb.append(c);
                }
                dot = true;
            }
            else if((c < 123 && c > 96) || (c > 47 && c < 58) || c == '-' || c == '_') {
                sb.append(c);
                dot = false;
            }
        }

        if(sb.length() > 0 && sb.charAt(0) == '.') sb.delete(0, 1);
        if(sb.length() > 0 && sb.charAt(sb.length() - 1) == '.') sb.delete(sb.length() - 1, sb.length());
        if(sb.length() == 0) sb.append('a');

        if(sb.length() > 15) sb.setLength(15);
        if(sb.length() > 0 && sb.charAt(sb.length()-1) == '.') sb.delete(sb.length()-1, sb.length());

        if(sb.length() < 3){
            while (sb.length() < 3) sb.append(sb.charAt(sb.length()-1));
        }

        return sb.toString();
    }

    // result
    public static void main(String[] args) {
        Solution solution = new Solution();
//        solution.solution();
//        TreeNode node = solution.solution();
//        System.out.println(solution.solution());
        System.out.println(Result.literal(solution.solution(new_id)));
//        System.out.println(Result.one_demension(solution.solution(id_list, report, k)));
//        System.out.println(Result.two_demension(solution.solution(dist)));
    }
}