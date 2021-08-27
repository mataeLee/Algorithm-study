import java.util.*;

public class Main {
    // 프로그래머스 Lv.3 하노이의 탑

    //test case
    static int n = 6;

    //algorithm solution
    static class Solution {
        int idx = 0;
        public int[][] solution(int n) {
            int[][] answer = new int[(int)(Math.pow(2,n))-1][2];

            List<String> res = new ArrayList<>();

            dp(answer, n, 1, 3);
            return answer;
        }

        void dp(int[][] answer, int n, int a, int b){
            if(n <= 1){
                answer[idx][0] = a;
                answer[idx++][1] = b;
            }
            else{
                int c = 6-a-b; // 거쳐가는 기둥

                dp(answer, n-1,a,c);
                answer[idx][0] = a;
                answer[idx++][1] = b;
                dp(answer, n-1,c,b);
            }
        }
    }

    // result
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] answer = solution.solution(n);
        System.out.print("[");
        for(int i=0; i<answer.length; i++){
            System.out.print("["+answer[i][0]+", "+answer[i][1]+"]");
            if(i < answer.length - 1) System.out.print(", ");
        }
      System.out.print("]");
//        System.out.println(answer);
    }
}