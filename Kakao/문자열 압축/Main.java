import java.util.*;

public class Main {
    //test case
//    static String s = "abcabcabcabcdededededede";
//    static String s = "abcabcdede";
    //static String s = "ababcdcdababcdcd";
    //static String s = "abbbc";
    static String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";

    //algorithm solution
    static class Solution {
        public int solution(String s) {
            int answer = 1000;
            if(s.length() == 1) return 1;
            for (int i = 1; i <= s.length()/2; i++) {
                String[] arr = new String[1001];
                int arrIdx = 0;
                int subIdx = 0;
                while(true){
                    if(subIdx + i > s.length()){
                        arr[arrIdx] = s.substring(subIdx);
                        break;
                    }
                    arr[arrIdx++] = s.substring(subIdx, subIdx + i);
                    subIdx += i;
                }
                String res = "";
                String str = "";
                int cnt = 1;
                for(int j=0; j<arr.length; j++){
                    if(str == null) break;
                    if(str.equals(arr[j])) {
                        cnt++;
                        continue;
                    }
                    if(cnt > 1) {
                        res += cnt;
                        cnt = 1;
                    }
                    res += str;
                    str = arr[j];
                }
                if(answer > res.length()) answer = res.length();
            }
            return answer;
        }
    }

    // result
    public static void main(String[] args) {
        Solution solution = new Solution();
        int answer = solution.solution(s);
        System.out.println(answer);
    }
}