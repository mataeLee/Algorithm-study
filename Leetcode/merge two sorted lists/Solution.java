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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode answer = null;
        ListNode p = null;
        if(list1 == null) return list2;
        if(list2 == null) return list1;

        if(list1.val < list2.val){
            answer = new ListNode(list1.val);
            list1 = list1.next;
        }else {
            answer = new ListNode(list2.val);
            list2 = list2.next;
        }
        p = answer;
        while (list1 != null && list2 != null){
            if(list1.val < list2.val){
                p.next = list1;
                list1 = list1.next;
            }
            else{
                p.next = list2;
                list2 = list2.next;
            }
            p = p.next;
        }
        if(list1 == null){
            p.next = list2;
        }
        else
            p.next = list1;
        return answer;
    }

    // result
    public static void main(String[] args) {
        Solution solution = new Solution();

//        System.out.println(Result.literal(solution.solution(s)));
//        System.out.println(Result.one_demension(solution.solution(x)));
//        System.out.println(Result.two_demension(answer));
    }
}