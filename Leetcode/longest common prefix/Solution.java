import java.util.*;

public class Solution {
    //test case
    static String[] strs = {"flower","flow","flight"};

    //algorithm solution
    public String longestCommonPrefix(String[] strs) {
        StringBuilder answer = new StringBuilder();

        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        for(int i=0; i<strs[0].length(); i++){
            char c = strs[0].charAt(i);
            for(int j=1; j<strs.length; j++){
                if(strs[j].charAt(i) != c){
                    return answer.toString();
                }
            }
            answer.append(c);
        }

        return answer.toString();
    }

    // result
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(Result.literal(solution.longestCommonPrefix(strs)));
//        System.out.println(Result.one_demension(solution.solution(x)));
//        System.out.println(Result.two_demension(answer));
    }
}