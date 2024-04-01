import leetcode.TreeNode;

import java.util.*;

public class Solution {
    // 프로그래머스 카카오 오픈채팅방

    //test case
    static String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};

    //algorithm solution

    public String[] solution(String[] record) {
        Map<String, String> id_map = new HashMap<>();
        List<String> res = new ArrayList<>();

        for(int i=0; i<record.length; i++){
            String[] contents = record[i].split(" ");
            String key = contents[0];
            switch (key){
                case "Enter":
                    res.add(contents[1]+"님이 들어왔습니다.");
                    id_map.put(contents[1], contents[2]);
                    break;
                case "Leave":
                    res.add(contents[1]+"님이 나갔습니다.");
                    break;
                case "Change":
                    id_map.put(contents[1], contents[2]);
                    break;
            }
        }
        String[] answer = new String[res.size()];
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<res.size(); i++){
            sb.setLength(0);
            String[] contents = res.get(i).split("님");
            answer[i] = sb.append(id_map.get(contents[0])).append("님").append(contents[1]).toString();
        }
        return answer;
    }

    // result
    public static void main(String[] args) {
        Solution solution = new Solution();
//        solution.solution();
//        TreeNode node = solution.solution();
//        System.out.println(solution.solution());
//        System.out.println(Result.literal(solution.solution(dartResult)));
        System.out.println(Result.one_demension(solution.solution(record)));
//        System.out.println(Result.two_demension(solution.solution(dist)));
    }
}