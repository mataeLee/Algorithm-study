import java.math.BigInteger;
import java.util.*;

public class Solution {
    //test case
    static String s = "[()]";

    //algorithm solution
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
                continue;
            }
            if(stack.size() == 0) return false;
            if(c == ')') {
                if(stack.peek() == '(') stack.pop();
                else return false;
            }
            else if(c == ']') {
                if(stack.peek() == '[') stack.pop();
                else return false;
            }
            else if(c == '}') {
                if(stack.peek() == '{') stack.pop();
                else return false;
            }
        }
        if(stack.size() > 0) return false;
        return true;
    }

    // result
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(Result.literal(solution.isValid(s)));
//        System.out.println(Result.one_demension(solution.solution(x)));
//        System.out.println(Result.two_demension(answer));
    }
}