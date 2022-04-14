import leetcode.TreeNode;

import java.util.*;

public class Solution {
    // 프로그래머스 카카오 다트게임

    //test case
    static String dartResult = "1D2S#10S";

    //algorithm solution
    public int solution(String dartResult) {
        int answer = 0;
        int[] points = new int[3];
        int idx = 0;

        int score = 0;

        for(int i=0; i<dartResult.length(); i++){
            char c = dartResult.charAt(i);
            switch (c){
                case 'S':
                    break;
                case 'D':
                    score *= score;
                    break;
                case 'T':
                    score = score * score * score;
                    break;
                case '*':
                    score *= 2;
                    if(idx > 0) points[idx-1] *= 2;
                    break;
                case '#':
                    score *= -1;
                    break;
                case '1':
                    if(i > 0) points[idx++] = score;
                    if(dartResult.charAt(i+1) == '0') {
                        score = 10;
                        i++;
                    }
                    else score = 1;
                    break;
                default:
                    if(i > 0) points[idx++] = score;
                    score = c - '0';
                    break;
            }
        }
        points[2] = score;
        for(int i=0; i<3; i++) answer += points[i];
        return answer;
    }

    // result
    public static void main(String[] args) {
        Solution solution = new Solution();
//        solution.solution();
//        TreeNode node = solution.solution();
//        System.out.println(solution.solution());
        System.out.println(Result.literal(solution.solution(dartResult)));
//        System.out.println(Result.one_demension(solution.solution(n, arr1, arr2)));
//        System.out.println(Result.two_demension(solution.solution(dist)));
    }
}