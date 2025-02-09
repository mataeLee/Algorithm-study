import java.util.*;

public class Solution {
    //test case
    static int x = 2000000002;

    //algorithm solution
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        StringBuilder sb = new StringBuilder().append(x);
        char[] arr = sb.toString().toCharArray();
        for(int i=0; i<arr.length/2; i++){
            if(arr[i] != arr[arr.length-i-1]) return false;
        }
        return true;
    }

    // result
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(Result.literal(solution.isPalindrome(x)));
//        System.out.println(Result.one_demension(solution.solution(x)));
//        System.out.println(Result.two_demension(answer));
    }
}