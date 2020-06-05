import java.util.*;

public class Main {
    //test case
    static String p = ")(";

    //algorithm solution
    static class Solution {
        public String solution(String p) {
            if(verify(p)) return p;
            return recursive(p);
        }
        public String recursive(String w){
            // 1. 빈 문자열 리턴
            if(w.length() == 0) return "";

            int left = 0;
            int right = 0;
            String u = "", v = "";
            // 2. u, v로 분리
            for(int i=0; i<w.length(); i++){
                if(w.charAt(i) == '(') left++;
                else if(w.charAt(i) == ')') right++;
                if(left != 0 && right != 0 && left == right){
                    u = w.substring(0,i+1);
                    v = w.substring(i+1);
                    break;
                }
            }
            if(verify(u)){ // 검증
                // 3. 유효성 통과 시
                return u + recursive(v);
            }
            else{
                // 4. 유효성 실패 시
                StringBuilder sb = new StringBuilder();
                sb.append('('); // 4-1
                sb.append(recursive(v)); // 4-2
                sb.append(')'); // 4-3
                // 4-4
                u = u.substring(1);
                u = u.substring(0, u.length()-1);
                for(int i=0; i<u.length(); i++){
                    if(u.charAt(i) == '(') sb.append(')');
                    else sb.append('(');
                }
                return sb.toString();
            }
        }

        public boolean verify(String u){
            Stack<Character> stack = new Stack<>();
            for(int i=0; i<u.length(); i++){
                char ch = u.charAt(i);
                if(ch == '(') stack.push(ch);
                else {
                    if(stack.size() == 0) return false;
                    stack.pop();
                }
            }
            return true;
        }
    }

    // result
    public static void main(String[] args) {
        Solution solution = new Solution();
        String answer = solution.solution(p);
        System.out.println(answer);
    }
}