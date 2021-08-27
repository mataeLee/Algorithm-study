import java.util.*;

public class Main {
    // 프로그래머스 Lv.3 110 옮기기

    //test case
    static String[] s = {"1110","100111100","0111111010"};

    //algorithm solution
    static class Solution {
        public String[] solution(String[] s) {
            String[] answer = new String[s.length];
            String key = "110";
            StringBuilder sb = new StringBuilder();

            for(int i=0; i<s.length; i++){
                char[] arr = new char[s[i].length()];
                int rear = 0;
                int cnt = 0;
                String element = s[i];
                for (int j = 0; j < element.length(); j++) {
                    char c = element.charAt(j);
                    if (c == '0' && rear > 1) {
                        if (arr[rear-1] == '1' && arr[rear-2] == '1') {
                            rear -= 2;
                            cnt++;
                            continue;
                        }
                    }
                    arr[rear++] = c;
                }
                for(int j=0; j<rear; j++){
                    sb.append(arr[j]);
                }
                boolean ele = true;
                boolean zero = true;
                boolean one = true;
                for(int j=0; j<cnt; j++){
                    int idx = -1;
                    if(ele){
                        idx = sb.indexOf("11");
                        if(idx >= 0){
                            sb.insert(idx, key);
                            continue;
                        }
                        ele = false;
                    }
                    if(zero){
                        idx = sb.lastIndexOf("0");
                        if(idx >= 0) {
                            sb.insert(idx+1, key);
                            continue;
                        }
                        zero = false;
                    }
                    if(one){
                        idx = sb.indexOf("1");
                        if(idx >= 0) {
                            sb.insert(idx, key);
                            continue;
                        }
                        one = false;
                    }
                    sb.append(key);
                }
                answer[i] = sb.toString();
                sb.setLength(0);
            }
            return answer;
        }
    }

    // result
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] answer = solution.solution(s);
        System.out.print("[");
        for(int i=0; i<answer.length; i++){
            System.out.print(answer[i]);
            if(i < answer.length - 1) System.out.print(", ");
        }
      System.out.print("]");
//        System.out.println(answer);
    }
}