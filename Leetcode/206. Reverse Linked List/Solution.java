import leetcode.ListNode;

import java.math.BigInteger;
import java.util.*;

public class Solution {
    //test case
    static ListNode head;

    //algorithm solution
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        Stack<Integer> stack = new Stack<>();
        while (head.next != null){
            stack.push(head.val);
            head = head.next;
        }
        ListNode p = head;
        while (!stack.isEmpty()) {
            p.next = new ListNode(stack.pop());
            p = p.next;
        }
        p.next = null;

        return head;
    }

    // result
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(Result.linked_list(solution.reverseList(head)));
//        System.out.println(Result.literal();
//        System.out.println(Result.one_demension(num1));
//        System.out.println(Result.two_demension(answer));
    }
}