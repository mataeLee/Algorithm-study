import java.util.HashMap;
import java.util.Map;

public class Solution {
    // 프로그래머스 카카오 성격 유형 검사지

    //test case
    static String[] servey = {"TR", "RT", "TR"};
    static int[] choices = {7, 1, 3};

    public String solution(String[] survey, int[] choices) {
        StringBuilder sb = new StringBuilder();
        char[][] indexs = {{'R', 'T'}, {'C', 'F'}, {'J', 'M'}, {'A', 'N'}};
        Map<Character, Integer> pointMap = new HashMap<>();

        for(int i=0; i<indexs.length; i++){
            pointMap.put(indexs[i][0], 0);
            pointMap.put(indexs[i][1], 0);
        }

        for(int i=0; i<survey.length; i++){
            char type1 = survey[i].charAt(0);
            char type2 = survey[i].charAt(1);

            int point = choices[i] - 4;
            if(point < 0){
                pointMap.put(type1, pointMap.get(type1) + -point);
            }
            else if(point > 0){
                pointMap.put(type2, pointMap.get(type2) + point);
            }
        }

        for(int i=0; i<indexs.length; i++){
            char type1 = indexs[i][0];
            char type2 = indexs[i][1];

            int point1 = pointMap.get(type1);
            int point2 = pointMap.get(type2);
            if(point1 > point2) sb.append(type1);
            else if(point1 < point2) sb.append(type2);
            else{
                sb.append((type1 < type2)? type1 : type2);
            }
        }
        return sb.toString();
    }

    // result
    public static void main(String[] args) {
        Solution solution = new Solution();
//        solution.solution();
//        TreeNode node = solution.solution();
//        System.out.println(solution.solution());
        System.out.println(Result.literal(solution.solution(servey, choices)));
//        System.out.println(Result.one_demension(solution.solution(info, query)));
//        System.out.println(Result.two_demension(solution.solution(record)));
    }
}