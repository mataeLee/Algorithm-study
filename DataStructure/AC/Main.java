import java.io.*;
import java.util.*;

public class Main{
    // 백준 자료구조 AC - 5430
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<t; i++){
            String p = br.readLine();

            int n = Integer.parseInt(br.readLine());
            String str = br.readLine();
            str = str.substring(1);
            str = str.substring(0, str.length()-1);
            Deque<Integer> res = new LinkedList<>();
            if(str.length() > 0) {
                String[] strs = str.split(",");

                if (strs.length > 0) {
                    for (int j = 0; j < strs.length; j++) {
                        res.add(Integer.parseInt(strs[j]));
                    }
                }
            }

            boolean reverse = false;
            boolean error = false;

            for(int j=0; j<p.length(); j++){
                if(p.charAt(j) == 'R'){ // R
                    reverse = !reverse;
                }
                else{ // D
                    if(n==0){
                        error = true;
                        break;
                    }
                    //queue.poll
                    if (reverse) {
                        // 뒤부터 제거
                        res.pollLast();
                    } else {
                        // 앞부터 제거
                        res.pollFirst();
                    }
                    n--;
                }
            }
            if(error){
                sb.append("error").append("\n");
                continue;
            }
            sb.append("[");
            if(reverse) {
                while (res.size() > 0){
                    sb.append(res.pollLast());
                    if (res.size() > 0) sb.append(",");
                }
            }
            else{
                while (res.size() > 0){
                    sb.append(res.pollFirst());
                    if (res.size() > 0) sb.append(",");
                }
            }
            sb.append("]");
            sb.append("\n");
        }
        System.out.println(sb);
    }
}