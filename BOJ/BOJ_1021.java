import java.io.*;
import java.util.*;

public class Main{
    // 백준 자료구조 회전하는 큐 - 1021
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strs = br.readLine().split(" ");
        int n = Integer.parseInt(strs[0]);
        int m = Integer.parseInt(strs[1]);

        Deque<Integer> queue = new LinkedList<>();
        for(int i=0; i<n; i++){
            queue.add(i+1);
        }
        strs = br.readLine().split(" ");
        int answer = 0;
        for(int i=0; i<m; i++){
            int num = Integer.parseInt(strs[i]);
            int cnt = 0;
            while (queue.size() > 0){
                int val = queue.pollFirst();
                if(val == num){
                    break;
                }
                queue.addLast(val);
                cnt++;
            }
            if(cnt > queue.size()/2) answer += queue.size() - cnt + 1;
            else answer += cnt;
        }

        System.out.println(answer);
    }
}