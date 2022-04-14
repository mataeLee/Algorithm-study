import java.io.*;
import java.util.*;

public class Main{
    // 백준 자료구조 후위 표기식 - 1918

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        Map<Character, Integer> map = new HashMap<>();
        map.put('(', 0);
        map.put(')', 0);
        map.put('+', 1);
        map.put('-', 1);
        map.put('*', 2);
        map.put('/', 2);

        // priority
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(c > 64 && c < 91){
                sb.append(c);
            }
            else {
                if(stack.isEmpty()){
                    stack.push(c);
                }
                else{
                    if(c == '('){
                        stack.push(c);
                    }
                    else if(c == ')'){
                        while (!stack.isEmpty()){
                            char val = stack.pop();
                            if(val == '(')break;
                            sb.append(val);
                        }
                    }
                    else{
                        if(map.get(stack.peek()) >= map.get(c)){
                            while (!stack.isEmpty()){
                                if(map.get(stack.peek()) < map.get(c)) break;
                                sb.append(stack.pop());
                            }
                        }
                        stack.push(c);
                    }
                }
            }
        }
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }
}