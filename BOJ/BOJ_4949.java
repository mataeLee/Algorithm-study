import java.io.*;
import java.util.*;

public class Main{
    // 백준 스택 균형잡힌 세상 - 4949
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true){
            String str = br.readLine();
            if(str.equals(".")) break;
            boolean flag = false;
            Stack<Character> stack = new Stack<>();
            for(int i=0; i<str.length(); i++){
                char c = str.charAt(i);
                if(c == '(' || c== '[') stack.push(c);
                if(c == ')'){
                    if(stack.isEmpty() || stack.peek() != '(') {
                        flag = true;
                        break;
                    }
                    stack.pop();
                }
                if(c == ']'){
                    if(stack.isEmpty() || stack.peek() != '[') {
                        flag = true;
                        break;
                    }
                    stack.pop();
                }
            }
            if(!flag && stack.isEmpty()) sb.append("yes").append("\n");
            else sb.append("no").append("\n");
        }
        System.out.println(sb.toString());
    }
}