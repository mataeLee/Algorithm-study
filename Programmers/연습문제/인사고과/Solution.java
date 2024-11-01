import leetcode.ListNode;

import java.util.*;

public class Solution {
    // 프로그래머스 연습문제 인사고과 - level3

    // test case
//    public static int[][] scores = {{2, 2}, {1, 4}, {3, 2}, {3, 2}, {2, 1}};
//    public static int[][] scores = {{3, 2}, {2, 3}, {3, 2}, {2, 3}};
//    public static int[][] scores = {{2, 2}, {2, 3}, {1, 4}, {2, 5}};
//    public static int[][] scores = {{3, 1}, {2, 5}, {2, 10}};
    public static int[][] scores = {{4, 0}, {2, 3}, {4, 4}, {2, 6}};

    // algorithm solution
    public int solution(int[][] scores) {
        int[] targetScore = scores[0];
        int targetSum = scores[0][0] + scores[0][1];

        // 근무태도 내림차순, 동료평가 오름차순 1차 정렬
        Arrays.sort(scores, (o1, o2) -> o1[0] == o2[0]? o1[1] - o2[1] : o2[0] - o1[0]);

        // 인센티브 못받는 사원 소거
        int stdScore1 = scores[0][0];
        int stdScore2 = scores[0][1];

        for(int score[]: scores) {
            if(stdScore1 > score[0]){
                if(stdScore2 > score[1]){
                    // 타겟인 경우 리턴
                    if(score.equals(targetScore)) return -1;
                    score[0] = -1;
                    score[1] = -1;
                }
            }
            if(stdScore2 <= score[1]){
                stdScore1 = score[0];
                stdScore2 = score[1];
            }
        }

        // 합으로 내림차순 정렬
        Arrays.sort(scores, (o1, o2) -> (o2[0] + o2[1]) - (o1[0] + o1[1]));
        int rank = 1;
        for(int[] score: scores) {
            if(score.equals(targetScore)) return rank;

            if(score[0] + score[1] > targetSum) rank++;
        }

        return rank;
    }

    // result
    public static void main(String[] args) {
        Solution main = new Solution();
        System.out.println(main.solution(scores));
//        System.out.println(Result.literal(main.solution(coin, cards)));
//        System.out.println(Result.one_demension(main.solution(dice)));
//        System.out.println(Result.two_demension(main.solution(rc, operations)));
    }
}