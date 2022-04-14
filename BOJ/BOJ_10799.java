import java.io.*;
import java.util.*;

public class Main{
    // 백준 자료구조 쇠막대기 - 10799
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();
        int res = 0;
        char before = ' ';
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(c == ')'){
                stack.pop();
                if(before == '(') res+=stack.size();
                else res++;
            }
            if(c == '(') stack.push(c);
            before = c;
        }
        System.out.println(res);
    }
}