import java.util.*;

public class Main {
    // test case
    static String name = "JAN";

    // algorithm solution
    static class Solution {
        public int solution(String name) {
            int answer = 0;
            StringBuilder target = new StringBuilder();
            StringBuilder begin = new StringBuilder(name);
            for(int i=0; i<name.length(); i++){
                target.append("A");
            }
            int idx = 0;
            while(true){
                if(begin.toString().equals(target.toString()))
                    break;
                int a = greedy(begin, target, idx, true);
                int b = greedy(begin, target, idx, false);
                if(a == 0 || b== 0)
                    return 0;

                int alpha = begin.charAt(idx) - 65;
                begin.setCharAt(idx,'A');

                if(a <= b)
                    idx++;
                else
                    idx--;
                if(idx > target.length())
                    idx = 0;
                if(idx < 0)
                    idx = target.length()-1;

                if (alpha <= 13)
                   answer += alpha;
                else
                    answer +=  (26 - alpha);
                answer++;
            }


            return answer-1;
        }

        public int greedy(StringBuilder begin, StringBuilder target, int idx, boolean dir) {
            if (begin.toString().equals(target.toString()))
                return 0;
            StringBuilder sb = new StringBuilder(begin);
            if(idx >= target.length())
                idx = 0;
            if(idx < 0)
                idx = target.length()-1;

            int alpha = sb.charAt(idx) - 65;
            sb.setCharAt(idx,'A');

            if(dir)
                idx++;
            else
                idx--;

            if (alpha <= 13) {
                return greedy(sb, target, idx, dir) + alpha + 1;
            }
            else {
                return greedy(sb, target, idx, dir) + 27 - alpha;
            }
        }
    }

    // result
    public static void main(String[] args) {
        Solution solution = new Solution();
        int answer = solution.solution(name);
        System.out.println(answer);

//        System.out.print("[");
//        for(int i=0; i<answer.length; i++){
//            System.out.print(answer[i]);
//            if(i<answer.length-1)
//                System.out.print(", ");
//        }
//        System.out.print("]");
    }
}