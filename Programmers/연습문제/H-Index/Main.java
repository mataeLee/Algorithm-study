import java.util.*;

public class Main {

    // test case
    static int [] citations = {22, 42};

    static class Solution {
        public int solution(int[] citations) {
            int answer = 0;

            Arrays.sort(citations);

            for(int i=0; i<=citations.length; i++){
                int cnt = 0;
                for(int j=0 ;j<citations.length; j++){
                    if(i <= citations[j])
                        cnt++;
                }
                if(i <= cnt && i >= citations.length - cnt )
                    answer = i;
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int answer = solution.solution(citations);
        System.out.println(answer);
    }
}