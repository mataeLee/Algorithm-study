import leetcode.TreeNode;

import java.util.*;

public class Solution {
    // 프로그래머스 카카오 비밀지도

    //test case
    static int[] arr1 = {9, 20, 28, 18, 11};
    static int[] arr2 = {30, 1, 21, 17, 28};
    static int n = 5;

    //algorithm solution
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            sb.setLength(0);
            String str1 = binary(arr1[i], n);
            String str2 = binary(arr2[i], n);
            for(int j=0; j<n; j++){
                if(str1.charAt(j) == '0' && str2.charAt(j) == '0') sb.append(' ');
                else sb.append('#');
            }
            answer[i] = sb.toString();
        }
        return answer;
    }

    private String binary(int i, int n) {
        StringBuilder sb = new StringBuilder();
        while (i > 0) {
            sb.append(i%2);
            i /= 2;
        }
        while (sb.length() < n) sb.append(0);
        return sb.reverse().toString();
    }

    // result
    public static void main(String[] args) {
        Solution solution = new Solution();
//        solution.solution();
//        TreeNode node = solution.solution();
//        System.out.println(solution.solution());
//        System.out.println(Result.literal(solution.solution(numbers, hand)));
        System.out.println(Result.one_demension(solution.solution(n, arr1, arr2)));
//        System.out.println(Result.two_demension(solution.solution(dist)));
    }
}