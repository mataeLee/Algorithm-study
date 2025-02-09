import leetcode.ListNode;

import java.math.BigInteger;
import java.util.*;

public class Solution {
    //test case
    static int[] nums = {1, 2, 3, 1};

    //algorithm solution
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            if(set.contains(nums[i])) return true;
            set.add(nums[i]);
        }
        return false;
    }

    // result
    public static void main(String[] args) {
        Solution solution = new Solution();

//        System.out.println(Result.linked_list(solution.reverseList(head)));
        System.out.println(Result.literal(solution.containsDuplicate(nums)));
//        System.out.println(Result.one_demension(num1));
//        System.out.println(Result.two_demension(answer));
    }
}