import java.util.*;

public class Solution {
    //test case
    static int n = 8;

    //algorithm solution
    List<String> answer = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        char[] out = new char[n*2];
        recursive(0, out, n);
        return answer;
    }

    public void recursive(int level, char[] out, int n){
        if(level == n*2){
            StringBuilder sb = new StringBuilder();
            Stack<Character> stack = new Stack<>();
            for(int i=0; i<out.length; i++){
                sb.append(out[i]);
                if(out[i] == '(') stack.push(out[i]);
                else{
                    if(stack.size() == 0) return;
                    stack.pop();
                }
            }
            if(stack.size() > 0) return;
            answer.add(sb.toString());
            return;
        }
        out[level] = '(';
        recursive(level+1, out, n);
        out[level] = ')';
        recursive(level+1, out, n);
    }

    // result
    public static void main(String[] args) {
        Solution solution = new Solution();

//        System.out.println(Result.linked_list(solution.reverseList(head)));
//        System.out.println(Result.literal(solution.canFinish(numCourses, prerequisites)));
        System.out.println(Result.one_demension(solution.generateParenthesis(n)));
//        System.out.println(Result.two_demension(solution.levelOrder(null)));
    }
}