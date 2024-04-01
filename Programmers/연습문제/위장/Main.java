import java.util.*;
public class Main {

    // test case
    static String [][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};

    static class Solution {
        public int solution(String[][] clothes) {
            int answer = 1;
            Map<String, Integer> kind = new HashMap<>();

            for (int i = 0; i < clothes.length; i++) {
                String a = clothes[i][1];
                if (kind.get(a) != null)
                    kind.put(a, kind.get(a) + 1);
                else {
                    kind.put(a, 1);
                }
            }
            Collection<Integer> collection = kind.values();
            Iterator iterator = collection.iterator();
            while (iterator.hasNext()) {
                if (iterator.hasNext())
                    answer *= ((int) iterator.next() + 1);
            }
            return answer - 1;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(clothes));
    }
}