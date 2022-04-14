import java.io.*;
import java.util.*;

public class Main{
    // 백준 자료구조 탑 - 2493
    static class Tower{
        int idx;
        int val;

        public Tower(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int max = 0;
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        Stack<Tower> stack = new Stack<>();

        for(int i=0; i<n; i++){
            Tower tower = new Tower(i+1, Integer.parseInt(st.nextToken()));

            if(stack.isEmpty()){
                sb.append(0);
            }
            else{
                while (!stack.isEmpty()){
                    if(stack.peek().val > tower.val){
                        sb.append(stack.peek().idx);
                        break;
                    }
                    stack.pop();
                }
                if(stack.isEmpty()) {
                    sb.append(0);
                }
            }
            stack.push(tower);
            if(i < n-1) sb.append(" ");
        }
        System.out.println(sb);
    }
}