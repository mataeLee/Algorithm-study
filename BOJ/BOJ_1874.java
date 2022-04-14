import java.io.*;
import java.util.*;

public class Main{
    // 백준 스택 스택 수열 - 1874
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] stack = new int[n];
        int top = -1;
        int val = 1;
        for(int i=0; i<n; i++){
            int num = Integer.parseInt(br.readLine());
            while (true){
                if(top != -1 && stack[top] > num && val > num) {
                    System.out.println("NO");
                    return;
                }
                if(top == -1 || stack[top] < num){
                    stack[++top] = val++;
                    sb.append("+").append("\n");
                }
                else{
                    int pop = stack[top--];
                    sb.append("-").append("\n");
                    if(pop == num) break;
                }
            }
        }
        System.out.println(sb);
    }
}