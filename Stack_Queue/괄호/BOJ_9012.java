import java.io.*;
import java.util.*;

public class Main{
    // 백준 스택 괄호 - 9012
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            String str = br.readLine();
            Stack<Character> stack = new Stack<>();
            boolean flag = false;
            for(int j=0; j<str.length(); j++){
                if(str.charAt(j) == '(') {
                    stack.push('(');
                    continue;
                }
                if(stack.isEmpty()){
                    flag = true;
                    break;
                }
                stack.pop();
            }
            if(!flag && stack.isEmpty()) sb.append("YES").append("\n");
            else sb.append("NO").append("\n");
        }
        System.out.println(sb.toString());
    }
}