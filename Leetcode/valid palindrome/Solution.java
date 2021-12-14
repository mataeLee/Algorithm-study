import java.math.BigInteger;
import java.util.*;

public class Solution {
    //test case
    static String s = "A man, a plan, a canal: Panama";

    //algorithm solution
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c >= 'A' && c <= 'Z'){
                sb.append(Character.toLowerCase(c));
            }
            else if(c >= 'a' && c <= 'z'){
                sb.append(c);
            }
            else if(c >= '0' && c <= '9'){
                sb.append(c);
            }
        }
        for(int i=0; i<sb.length()/2; i++){
            if(sb.charAt(i) != sb.charAt(sb.length()-1-i)) return false;
        }
        return true;
    }

    // result
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(Result.literal(solution.isPalindrome(s)));
//        System.out.println(Result.one_demension(num1));
//        System.out.println(Result.two_demension(answer));
    }
}