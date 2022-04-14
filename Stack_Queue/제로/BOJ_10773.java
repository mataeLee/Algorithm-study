import java.io.*;
import java.util.*;

public class Main{
    // 백준 스택 제로 - 10773
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<n; i++){
            int num = Integer.parseInt(br.readLine());
            if(num == 0 && !stack.isEmpty()){
                stack.pop();
            }
            else {
                stack.push(num);
            }
        }
        int sum = 0;
        while (!stack.isEmpty()){
            sum += stack.pop();
        }
        System.out.println(sum);
    }
}