import java.util.*;

public class Main {
    // 프로그래머스 Lv.3 다단계 칫솔 판매

    //test case
    static String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
    static String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
    static String[] seller = {"young", "john", "tod", "emily", "mary"};
    static int[] amount = {12, 4, 2, 5, 10};

    //algorithm solution
    static class Solution {
        public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
            int[] answer = new int[enroll.length];
            // 각자 인덱스 해싱
            Map<String, Integer> hs = new HashMap<String, Integer>();
            for (int i = 0; i < enroll.length; i++) {
                hs.put(enroll[i], i);
            }
            hs.put("-", -1); // center

            for (int i = 0; i < seller.length; i++) {
                String sell = seller[i];
                int amt = amount[i] * 100;
                dividend(hs, hs.get(sell), referral, amt, answer);
            }
            return answer;
        }

        void dividend(Map<String, Integer> hs, int seller, String[] referral, int amount, int[] answer) {
            if (seller == -1) return;
            int fee = amount / 10;
            if (fee < 1) {
                answer[seller] += amount;
                return;
            }
            answer[seller] += amount - fee;
            dividend(hs, hs.get(referral[seller]), referral, fee, answer);
        }
    }
    // result
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] answer = solution.solution(enroll, referral, seller, amount);
        System.out.print("[");
        for(int i=0; i<answer.length; i++){
            System.out.print(answer[i]);
            if(i < answer.length - 1) System.out.print(", ");
        }
        System.out.print("]");
//        System.out.println(answer);
    }
}