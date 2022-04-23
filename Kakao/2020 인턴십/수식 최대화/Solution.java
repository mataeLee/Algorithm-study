import leetcode.TreeNode;

import java.util.*;

public class Solution {
    // 프로그래머스 카카오 수식 최대화

//    //test case
    static String expression = "1+2+3";

    //algorithm solution
    long answer = 0;
    public long solution(String expression) {
        List<Long> nums = new ArrayList<>();
        List<Character> ops = new ArrayList<>();

        int idx = 0;
        Map<Integer, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();

        int cnt = 0;

        for(int i=0; i<expression.length(); i++){
            char c = expression.charAt(i);
            if(c == '+' || c == '-' || c == '*'){
                nums.add(Long.parseLong(expression.substring(idx, i)));
                ops.add(c);
                if(!set.contains(c)) map.put(cnt++, c);
                set.add(c);
                idx = i+1;
            }
        }
        nums.add(Long.parseLong(expression.substring(idx)));

        int[] out = new int[map.size()];
        boolean[] visited = new boolean[map.size()];
        recursive(out, nums, ops, map, visited, 0);

        return answer;
    }

    public void recursive(int[] out, List<Long> nums, List<Character> ops, Map<Integer, Character> map, boolean[] visited, int level){
        if(level == out.length){
            List<Long> numbers = new ArrayList<>();
            numbers.addAll(nums);
            List<Character> opers = new ArrayList<>();
            opers.addAll(ops);

            for(int i=0; i<out.length; i++){
                char c = map.get(out[i]);
                long sum = 0;
                for(int j=0; j<opers.size(); j++){
                    if(opers.get(j) == c){
                        long num1 = numbers.get(j);
                        long num2 = numbers.get(j+1);
                        switch (c){
                            case '+':
                                sum = num1 + num2;
                                break;
                            case '*':
                                sum = num1 * num2;
                                break;
                            case '-':
                                sum = num1 - num2;
                        }
                        numbers.remove(j);
                        numbers.remove(j);
                        numbers.add(j,sum);
                        opers.remove(j);
                        j--;
                    }
                }
            }
            answer = Math.max(Math.abs(numbers.get(0)), Math.abs(answer));
            return;
        }
        for(int i=0; i<map.size(); i++){
            if(visited[i]) continue;
            out[level] = i;
            visited[i] = true;
            recursive(out, nums, ops, map, visited, level+1);
            visited[i] = false;
        }
    }

    // result
    public static void main(String[] args) {
        Solution solution = new Solution();
//        solution.solution();
//        TreeNode node = solution.solution();
//        System.out.println(solution.solution());
        System.out.println(Result.literal(solution.solution(expression)));
//        System.out.println(Result.one_demension(solution.solution(places)));
//        System.out.println(Result.two_demension(solution.solution(dist)));
    }
}