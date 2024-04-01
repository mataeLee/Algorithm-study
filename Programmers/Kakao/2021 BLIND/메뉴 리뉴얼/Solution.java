import leetcode.TreeNode;

import java.util.*;

public class Solution {
    // 프로그래머스 카카오 메뉴 리뉴얼

    //test case
    static String[] orders = {"XYZ", "XWY", "WXA"};
    static int[] course = {2, 3, 4};

    public Map<String, Integer> map = new HashMap<>();
    public int max = 0;
    public List<String> solution(String[] orders, int[] course) {
        List<String> res = new ArrayList<>();

        for(int i=0; i<course.length; i++){
            int num = course[i];
            map.clear();

            for(int j=0; j<orders.length; j++){
                char[] order = orders[j].toCharArray();
                Arrays.sort(order);

                if(num > order.length) continue;
                char[] out = new char[num];
                permutation(out, order, 0, 0);
            }

            Iterator<String> it = map.keySet().iterator();
            max = 0;

            while (it.hasNext()){
                String key = it.next();
                max = Math.max(max, map.get(key));
            }

            if(max > 1) {
                it = map.keySet().iterator();
                while (it.hasNext()) {
                    String key = it.next();
                    if (map.get(key) == max) res.add(key);
                }
            }
        }

        Collections.sort(res);
        return res;
    }

    private void permutation(char[] out, char[] order, int depth, int start) {
        if(depth == out.length){
            String outString = String.valueOf(out);
            System.out.println(outString);
            map.put(outString, map.getOrDefault(outString, 0)+1);
            return;
        }

        for(int i=start; i<order.length; i++) {
            out[depth] = order[i];
            permutation(out, order, depth + 1, i+1);
        }
    }

    // result
    public static void main(String[] args) {
        Solution solution = new Solution();
//        solution.solution();
//        TreeNode node = solution.solution();
//        System.out.println(solution.solution());
//        System.out.println(Result.literal(solution.solution(needs, r)));
        System.out.println(Result.one_demension(solution.solution(orders, course)));
//        System.out.println(Result.two_demension(solution.solution(record)));
    }
}