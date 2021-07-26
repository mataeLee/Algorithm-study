import java.util.*;

public class Main {
    // 프로그래머스 Lv.3 최고의 집합

    //test case
    static int n = 4;
    static int s = 17;

    //algorithm solution
    static class Solution {
        public int[] solution(int n, int s) {
            int[] answer = {};
            if(n > s){
                answer = new int[1];
                answer[0] = -1;
                return answer;
            }
            int middle = s / n;
            int rest = s % n;
            answer = new int[n];
            for(int i=0; i<n-rest; i++){
                answer[i] = middle;
            }
            for(int i=0; i<rest; i++){
                answer[n-rest+i] = middle+1;
            }

            return answer;
        }
    }

    // result
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] answer = solution.solution(n, s);

        // 상수
//        System.out.println(answer);

        // 1차원 배열
        System.out.print("[");
        for(int i=0; i<answer.length; i++){
            System.out.print(answer[i]);
            if(i < answer.length - 1) System.out.print(", ");
        }
        System.out.print("]");

        // 2차원 배열
//        System.out.print("[");
//        for(int i=0; i<answer.length; i++){
//            System.out.print("["+answer[i][0]+", "+answer[i][1]+"]");
//            if(i < answer.length - 1) System.out.print(", ");
//        }
//      System.out.print("]");
    }
}