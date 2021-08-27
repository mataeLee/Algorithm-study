import java.util.*;

public class Main {
    // 프로그래머스 Lv.3 가장 긴 팰린드롬

    //test case
    static String s = "abcdcba";

    //algorithm solution
    static class Solution{
        public int solution(String s){
            int answer = 1;
            for(int i=0; i<s.length()-1; i++){
                int len = s.length()-i;
                for(int j=0; j<s.length()-len+1; j++){
                    int start = j;
                    int end = j+len-1;
                    if(check(s, start, end)) return len;
                }
            }
            return answer;
        }
        boolean check(String s, int start, int end){
            while(start < end){
                if(s.charAt(start) != s.charAt(end)) return false;
                start++;
                end--;
            }
            return true;
        }
    }

    // result
    public static void main(String[] args) {
        Solution solution = new Solution();
        int answer = solution.solution(s);
//        System.out.print("[");
//        for(int i=0; i<answer.length; i++){
//            System.out.print(answer[i]);
//            if(i < answer.length - 1) System.out.print(", ");
//        }
//      System.out.print("]");
        System.out.println(answer);
    }
}