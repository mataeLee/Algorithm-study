import leetcode.ListNode;
import leetcode.TreeNode;

import java.math.BigInteger;
import java.util.*;

public class Solution {
    //test case

    //algorithm solution
    public List<List<Integer>> answer = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        inorder(root, 0);
        return answer;
    }

    public void inorder(TreeNode root, int level){
        if(root != null){
            if(answer.get(level) == null) answer.add(new ArrayList<>());
            inorder(root.right, level+1);
            answer.get(level).add(root.val);
            inorder(root.left, level+1);
        }
    }

    // result
    public static void main(String[] args) {
        Solution solution = new Solution();

//        System.out.println(Result.linked_list(solution.reverseList(head)));
//        System.out.println(Result.literal(solution.majorityElement(nums)));
//        System.out.println(Result.one_demension(num1));
        System.out.println(Result.two_demension(solution.levelOrder(null)));
    }
}