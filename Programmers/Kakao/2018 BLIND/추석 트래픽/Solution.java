import leetcode.TreeNode;

import java.util.*;

public class Solution {
    // 프로그래머스 카카오 추석 트래픽

    //test case
    static String[] lines = {"2016-09-15 20:59:57.421 0.351s",
            "2016-09-15 20:59:58.233 1.181s",
            "2016-09-15 20:59:58.299 0.8s",
            "2016-09-15 20:59:58.688 1.041s",
            "2016-09-15 20:59:59.591 1.412s",
            "2016-09-15 21:00:00.464 1.466s",
            "2016-09-15 21:00:00.741 1.581s",
            "2016-09-15 21:00:00.748 2.31s",
            "2016-09-15 21:00:00.966 0.381s",
            "2016-09-15 21:00:02.066 2.62s"};

    //algorithm solution
    class Task{
        double start;
        double end;
        Task(double start, double end){
            this.start = start;
            this.end = end;
        }
    }
    public int solution(String[] lines) {
        int answer = 0;

        List<Task> tasks = new ArrayList<>();
        for(int i=0; i<lines.length; i++){
            String[] strs = lines[i].split(" ");
            String[] time = strs[1].split(":");
            double end = (Integer.parseInt(time[0]) * 3600 + Integer.parseInt(time[1]) * 60 + Double.parseDouble(time[2]))*1000;
            double start = end - (Double.parseDouble(strs[2].substring(0, strs[2].length()-1)))*1000 + 1;
            tasks.add(new Task(start, end));
        }
        for(int i=0; i<tasks.size(); i++){
            Task std = tasks.get(i);
            double end = std.end + 999;
            int count = 0;
            for(int j=i; j<tasks.size(); j++){
                Task obj = tasks.get(j);
                if(obj.start <= end) count++;
            }
            if(answer < count) answer = count;
        }
        return answer;

    }

    // result
    public static void main(String[] args) {
        Solution solution = new Solution();
//        solution.solution();
//        TreeNode node = solution.solution();
//        System.out.println(solution.solution());
        System.out.println(Result.literal(solution.solution(lines)));
//        System.out.println(Result.one_demension(solution.solution(record)));
//        System.out.println(Result.two_demension(solution.solution(dist)));
    }
}