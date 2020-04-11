import java.util.*;

public class Main {
    // test case
    static String arrangement = "((()(())))";

    // algorithm solution
    static class Solution {
        public int solution(String arrangement) {
            int answer = 0;

            Stack<Character> stack = new Stack<>();

            for(int i=0; i<arrangement.length(); i++){
                char c = arrangement.charAt(i);
                char c2;
                if(i < arrangement.length()-1) {
                    c2 = arrangement.charAt(i + 1);
                    if (c == '(' && c2 == ')') {
                        stack.push('*');
                        i++;
                        continue;
                    }
                }
                if(c == '('){
                    stack.push(c);
                }
                else if(c == ')'){
                    int laser = 0;
                    while(true){
                        char ch = stack.pop();
                        if(ch == '('){
                            answer += laser +1;
                            for(int j=0; j<laser; j++){
                                stack.push('*');
                            }
                            break;
                        }
                        else if(ch == '*')
                            laser ++;
                    }
                }
            }
            return answer;
        }
    }

    // result
    public static void main(String[] args) {
        Solution solution = new Solution();
        int answer = solution.solution(arrangement);
        System.out.println(answer);
    }

}
