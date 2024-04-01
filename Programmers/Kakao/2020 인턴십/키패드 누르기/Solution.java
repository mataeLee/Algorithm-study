import leetcode.TreeNode;

import java.util.*;

public class Solution {
    // 프로그래머스 카카오 키패드 누르기
    //test case
    static int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
    static String hand = "left";

    //algorithm solution
    public String solution(int[] numbers, String hand) {
        int[][] phone = {{3, 1}, {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}};

        int l_x = 3;
        int l_y = 0;
        int r_x = 3;
        int r_y = 2;

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<numbers.length; i++){
            int num = numbers[i];
            int num_x = phone[num][0];
            int num_y = phone[num][1];

            if(num == 1 || num == 4 || num == 7){
                sb.append("L");
                l_x = num_x;
                l_y = num_y;
            }
            else if(num == 3 || num == 6 || num == 9){
                sb.append("R");
                r_x = num_x;
                r_y = num_y;
            }
            else{
                int l_len = Math.abs(l_x - num_x) + Math.abs(l_y - num_y);
                int r_len = Math.abs(r_x - num_x) + Math.abs(r_y - num_y);
                if(l_len < r_len){
                    sb.append("L");
                    l_x = num_x;
                    l_y = num_y;
                }
                else if(l_len > r_len){
                    sb.append("R");
                    r_x = num_x;
                    r_y = num_y;
                }
                else{
                    if(hand.equals("left")){
                        sb.append("L");
                        l_x = num_x;
                        l_y = num_y;
                    }
                    else{
                        sb.append("R");
                        r_x = num_x;
                        r_y = num_y;
                    }
                }
            }
        }

        return sb.toString();
    }

    // result
    public static void main(String[] args) {
        Solution solution = new Solution();
//        solution.solution();
//        TreeNode node = solution.solution();
//        System.out.println(solution.solution());
        System.out.println(Result.literal(solution.solution(numbers, hand)));
//        System.out.println(Result.one_demension(solution.solution(id_list, report, k)));
//        System.out.println(Result.two_demension(solution.solution(dist)));
    }
}