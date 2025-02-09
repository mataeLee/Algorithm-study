import java.math.BigInteger;
import java.util.*;

public class Solution {
    //test case
    static int[] num1 = {1,2,3,0,0,0};
    static int[] num2 = {2,5,6};
    static int n = 3;
    static int m = 3;

    //algorithm solution
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i=0; i<n; i++){
            nums1[m+i] = nums2[i];
        }
        Arrays.sort(nums1);
    }

    // result
    public static void main(String[] args) {
        Solution solution = new Solution();

        solution.merge(num1, m, num2, n);
//        System.out.println(Result.literal(solution.merge(s)));
        System.out.println(Result.one_demension(num1));
//        System.out.println(Result.two_demension(answer));
    }
}