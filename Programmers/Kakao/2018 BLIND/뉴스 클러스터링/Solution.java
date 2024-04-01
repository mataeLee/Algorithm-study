import leetcode.TreeNode;

import java.util.*;

public class Solution {
    // 프로그래머스 카카오 뉴스 클러스터링

    //test case
    static String str1 = "A+C";
    static String str2 = "DEF";

    public int solution(String str1, String str2) {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();

        for(int i=0; i<str1.length()-1; i++){
            char c1 = str1.charAt(i);
            char c2 = str1.charAt(i+1);
            if((c1 > 64 && c1 < 91) && (c2 > 64 && c2 < 91))
                list1.add(str1.substring(i, i+2));
        }

        for(int i=0; i<str2.length()-1; i++){
            char c1 = str2.charAt(i);
            char c2 = str2.charAt(i+1);
            if((c1 > 64 && c1 < 91) && (c2 > 64 && c2 < 91))
                list2.add(str2.substring(i, i+2));
        }

        Collections.sort(list1);
        Collections.sort(list2);

        List<String> interList = new ArrayList<>();

        int idx1 = 0;
        int idx2 = 0;

        while (idx1 < list1.size() && idx2 < list2.size()){
            String val1 = list1.get(idx1);
            String val2 = list2.get(idx2);

            int val = val1.compareTo(val2);
            if(val > 0) idx2++;
            else if(val < 0) idx1++;
            else{
                interList.add(val1);
                idx1++;
                idx2++;
            }
        }

        int unionLen = list1.size() + list2.size() - interList.size();

        double sum = 1;
        if(interList.size() > 0 && unionLen > 0) sum = ((double)interList.size() / (double)unionLen);
        if(interList.size() == 0 && unionLen > 0) return 0;
        int answer = (int)(sum * 65536);

        return answer;
    }

    // result
    public static void main(String[] args) {
        Solution solution = new Solution();
//        solution.solution();
//        TreeNode node = solution.solution();
//        System.out.println(solution.solution());
        System.out.println(Result.literal(solution.solution(str1, str2)));
//        System.out.println(Result.one_demension(solution.solution(info, query)));
//        System.out.println(Result.two_demension(solution.solution(record)));
    }
}