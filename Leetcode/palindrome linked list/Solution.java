import leetcode.ListNode;

import java.math.BigInteger;
import java.util.*;

public class Solution {
    //test case
    static ListNode head;

    //algorithm solution
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null){
            list.add(head.val);
            head = head.next;
        }
        for(int i=0; i<list.size()/2; i++){
            if(list.get(i) != list.get(list.size()-1-i)) return false;
        }
        return true;
    }

    // result
    public static void main(String[] args) {
        Solution solution = new Solution();

//        System.out.println(Result.linked_list(solution.reverseList(head)));
        System.out.println(Result.literal(solution.isPalindrome(head)));
//        System.out.println(Result.one_demension(num1));
//        System.out.println(Result.two_demension(answer));
    }
}