import java.math.BigInteger;
import java.util.*;

public class Solution {
    //test case

    //algorithm solution

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        boolean carry = false;
        ListNode answer;
        if(l1.val + l2.val > 9) {
            carry = true;
            answer = new ListNode(l1.val + l2.val - 10);
        }
        else{
            answer = new ListNode(l1.val + l2.val);
        }
        ListNode p = answer;
        l1 = l1.next;
        l2 = l2.next;

        while (true){
            if(l1 == null && l2 == null) break;
            int sum = 0;
            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            if(carry) sum++;
            if(sum > 9){
                carry = true;
                sum -= 10;
            }
            else {
                carry = false;
            }
            p.next = new ListNode(sum);
            p = p.next;
        }
        if(carry){
            p.next = new ListNode(1);
        }
        return answer;
    }

    // result
    public static void main(String[] args) {
        Solution solution = new Solution();

        solution.addTwoNumbers(null, null);

//        System.out.println(Result.literal(solution.solution(s)));
//        System.out.println(Result.one_demension(solution.solution(x)));
//        System.out.println(Result.two_demension(answer));
    }
}