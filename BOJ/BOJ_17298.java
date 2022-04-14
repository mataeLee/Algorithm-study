import java.io.*;
import java.util.*;

public class Main{
    // 백준 스택 오큰수 - 17298
    static class NGE implements Comparable<NGE>{
        int num;
        int idx;
        int val;

        public NGE(int num, int idx, int val) {
            this.num = num;
            this.idx = idx;
            this.val = val;
        }

        @Override
        public int compareTo(NGE o) {
            return this.idx - o.idx;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<NGE> stack = new Stack<>();
        String[] strs = br.readLine().split(" ");
        List<NGE> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            int num = Integer.parseInt(strs[i]);
            if(stack.isEmpty()){
                stack.push(new NGE(num, i, -1));
                continue;
            }
            while (!stack.isEmpty()) {
                if(stack.peek().num >= num) break;
                NGE nge = stack.pop();
                nge.val = num;
                list.add(nge);
            }
            stack.push(new NGE(num, i, -1));
        }
        while (!stack.isEmpty()){
            list.add(stack.pop());
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            sb.append(list.get(i).val);
            if(i<n-1) sb.append(" ");
        }
        System.out.println(sb.toString());
    }
}