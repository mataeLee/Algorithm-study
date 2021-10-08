import java.util.*;

public class Solution {
    // 프로그래머스 Lv.2 124 나라의 숫자

    //test case
    static int n = 5;

    //algorithm solution
    public String solution(int n) {
        int[] num = {4, 1, 2};
        StringBuilder sb = new StringBuilder();
        while(n > 0){
            sb.append(num[n % 3]);
            n = (n - 1) / 3;
        }
        return sb.reverse().toString();
    }

    // result
    public static void main(String[] args) {
        Solution solution = new Solution();
        String answer = solution.solution(n);

        System.out.println(Result.literal(answer));
//        System.out.println(Result.one_demension(answer));
//        System.out.println(Result.two_demension(answer));
    }
}