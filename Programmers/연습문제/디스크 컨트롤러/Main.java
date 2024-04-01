import java.util.*;

public class Main {
    //test case
    //static int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
    static int[][] jobs = {{24, 10}, {18, 39}, {34, 20}, {37, 5}, {47, 22}, {20, 47}, {15, 2}, {15, 34}, {35, 43}, {26, 1}};

    //static int[][] jobs = {{0, 10}, {2, 3}, {9, 3}}; // 9 ok
    //static int[][] jobs = {{0, 3}, {1, 9}, {2, 6}}; //

    //algorithm solution
    static class Solution {
        class Job implements Comparable<Job>{
            public int req;
            public int run;
            public int idx;
            public boolean worked;

            public Job(int req, int run, int idx) {
                this.req = req;
                this.run = run;
                this.idx = idx;
            }

            @Override
            public int compareTo(Job job) {
               if(this.run > job.run) return 1;
               else if(this.run == job.run) return 0;
               else return -1;
            }
        }
        public int solution(int[][] jobs) {
            int answer = 0;
            int cnt = 0, time = 0;
            Job[] jobArr = new Job[jobs.length];
            for(int i=0; i<jobs.length; i++){
                jobArr[i] = new Job(jobs[i][0], jobs[i][1], i);
            }
            Arrays.sort(jobArr);

            while(cnt < jobs.length){
                int min = 100000000;
                int idx = -1;
                for(int i=0; i<jobArr.length; i++){
                    if(jobArr[i].req <= time && !jobArr[i].worked && jobArr[i].run < min) {
                        min = jobArr[i].run;
                        idx = i;
                    }
                }
                if(idx < 0){
                    for(int i=0; i<jobArr.length; i++){
                        if(!jobArr[i].worked && jobArr[i].req < min){
                            min = jobArr[i].req;
                            idx = i;
                        }
                    }
                    time = jobArr[idx].run + jobArr[idx].req;
                    answer += jobArr[idx].run;
                }else {
                    answer += time - jobArr[idx].req + min;
                    time += jobArr[idx].run;
                }
                jobArr[idx].worked = true;
                cnt++;
            }
            return answer/jobs.length;
        }
    }
    // result
    public static void main(String[] args) {
        Solution solution = new Solution();
        int answer = solution.solution(jobs);
        System.out.println(answer);
    }
}