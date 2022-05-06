import leetcode.TreeNode;

import java.util.*;

public class Solution {
    // 프로그래머스 카카오 순위 검색

    //test case
    static String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
    static String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};

    String[] languages = {"java", "cpp", "python"};
    String[] jobs = {"backend", "frontend"};
    String[] careers = {"junior", "senior"};
    String[] foods = {"pizza", "chicken"};
    public int[] solution(String[] info, String[] query) {

        Map<Set<String>, List<Integer>> map = new HashMap<>();

        for(int i=0; i<3; i++){
            String lan = languages[i];
            for(int j=0; j<2; j++){
                String job = jobs[j];
                for(int k=0; k<2; k++){
                    String career = careers[k];
                    for(int l=0; l<2; l++){
                        String food = foods[l];
                        Set<String> set = new HashSet<>();
                        set.add(lan);
                        set.add(job);
                        set.add(career);
                        set.add(food);
                        map.put(set, new ArrayList<>());
                    }
                }
            }
        }


        for(int i=0; i<info.length; i++){
            String[] strs = info[i].split(" ");
            Set<String> val = new HashSet<>();
            val.add(strs[0]);
            val.add(strs[1]);
            val.add(strs[2]);
            val.add(strs[3]);
            int x = Integer.parseInt(strs[4]);

            if(map.containsKey(val)){
                map.get(val).add(x);
            }
        }

        for(Set key : map.keySet()) Collections.sort(map.get(key));

        int[] answer = new int[query.length];

        for(int i=0; i<query.length; i++){
            String[] strs = query[i].split(" ");
            Set<String> val = new HashSet<>();

            int target = Integer.parseInt(strs[7]);

            if(!strs[0].equals("-")) val.add(strs[0]);
            if(!strs[2].equals("-")) val.add(strs[2]);
            if(!strs[4].equals("-")) val.add(strs[4]);
            if(!strs[6].equals("-")) val.add(strs[6]);

            for(Set key : map.keySet()){
                if(key.containsAll(val)){
                    List<Integer> valList = map.get(key);

                    int start = 0;
                    int end = valList.size()-1;
                    int mid = (end+start)/2;

                    while (end >= start){
                        if(valList.get(mid) < target){
                            start = mid + 1;
                        }
                        else end = mid - 1;
                        mid = (end+start)/2;
                    }
                    answer[i] += valList.size() - (end+1);
                }
            }
        }
        return answer;
    }

    // result
    public static void main(String[] args) {
        Solution solution = new Solution();
//        solution.solution();
//        TreeNode node = solution.solution();
//        System.out.println(solution.solution());
//        System.out.println(Result.literal(solution.solution(needs, r)));
        System.out.println(Result.one_demension(solution.solution(info, query)));
//        System.out.println(Result.two_demension(solution.solution(record)));
    }
}