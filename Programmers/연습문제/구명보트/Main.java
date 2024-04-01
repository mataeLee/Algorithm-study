import com.sun.org.apache.regexp.internal.RE;

import java.util.*;

public class Main {
    // test case
    static int[] people = {70, 50, 80, 50};
    static int limit = 100;

    // algorithm solution
    static class Solution {
        public int solution(int[] people, int limit) {
            int answer = 0;

            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < people.length; i++) {
                list.add(people[i]);
            }

            Collections.sort(list, Collections.reverseOrder());

            int idx = list.size() - 1;
            for (int i = 0; i < list.size() && i <= idx; i++) {
                int a = list.get(i);
                if (a + list.get(idx) <= limit) {
                    idx--;
                }
                answer++;
            }
            return answer;
        }
    }
    // result
    public static void main(String[] args) {
        Solution solution = new Solution();
        int answer = solution.solution(people, limit);
        System.out.println(answer);
    }
}