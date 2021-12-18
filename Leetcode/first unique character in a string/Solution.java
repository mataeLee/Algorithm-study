import leetcode.ListNode;

import java.math.BigInteger;
import java.util.*;

public class Solution {
    //test case
    static String s = "loveleetcode";

    //algorithm solution
    public int firstUniqChar(String s) {
        Map<Character, Integer> count = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(!count.containsKey(c)){
                count.put(c, 1);
            }
            else{
                count.put(c, count.get(c)+1);
            }
        }
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(count.get(c) == 1) return i;
        }
        return -1;
    }

    // result
    public static void main(String[] args) {
        Solution solution = new Solution();

//        System.out.println(Result.linked_list(solution.reverseList(head)));
        System.out.println(Result.literal(solution.firstUniqChar(s)));
//        System.out.println(Result.one_demension(num1));
//        System.out.println(Result.two_demension(answer));
    }
}