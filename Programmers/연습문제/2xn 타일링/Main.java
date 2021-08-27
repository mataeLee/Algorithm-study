import java.util.*;

public class Main {
    // 프로그래머스 Lv.3 2 x n 타일링

    //test case
    static int n = 4;

    //algorithm solution
    static class Solution {
        public int solution(int n) {
            int answer = 0;
            int[] arr = new int[n+1];
            arr[1] = 1;
            arr[2] = 2;
            for(int i=3; i<=n; i++){
                arr[i] = arr[i-1] % 1000000007 + arr[i-2] % 1000000007;
            }
            return arr[n] % 1000000007;
        }
    }
    // result
    public static void main(String[] args) {
        Solution solution = new Solution();
        int answer = solution.solution(n);
//        System.out.print("[");
//        for(int i=0; i<answer.length; i++){
//            System.out.print(answer[i]);
//            if(i < answer.length - 1) System.out.print(", ");
//        }
//      System.out.print("]");
        System.out.println(answer);
    }
}