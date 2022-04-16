import leetcode.TreeNode;

import java.util.*;

public class Solution {
    // 프로그래머스 카카오 표 편집

    //test case
    static int n = 8;
    static int k = 2;
    static String[] cmd = {"C","C","C","C","C","C", "U 1", "C", "Z"};

    //algorithm solution
    class Cell{
        public int idx;
        public int front = -1;
        public int next = -1;
        public boolean deleted = false;
        public Cell(int idx){
            this.idx = idx;
        }
    }

    public String solution(int n, int k, String[] cmd) {
        Cell[] chart = new Cell[n];

        for(int i=0; i<n; i++){
            Cell cell = new Cell(i);
            if(i > 0) cell.front = i-1;
            if(i < n-1) cell.next = i+1;
            chart[i] = cell;
        }

        Stack<Integer> del_stack = new Stack<>();

        for(int i=0; i<cmd.length; i++){
            String[] vals = cmd[i].split(" ");
            switch (vals[0]){
                case "U":
                    for(int j=0; j<Integer.parseInt(vals[1]); j++){
                        k = chart[k].front;
                    }
                    break;
                case "D":
                    for(int j=0; j<Integer.parseInt(vals[1]); j++){
                        k = chart[k].next;
                    }
                    break;
                case "C":
                    chart[k].deleted = true;
                    del_stack.push(k);
                    // 끝에 있는 경우
                    if(chart[k].next == -1){
                        if(chart[k].front != -1) chart[chart[k].front].next = -1;
                        k = chart[k].front;
                    }
                    else{
                        if(chart[k].front != -1) {
                            chart[chart[k].front].next = chart[chart[k].next].idx;
                            chart[chart[k].next].front = chart[chart[k].front].idx;
                        }
                        k = chart[k].next;
                    }
                    break;
                case "Z":
                    int idx = del_stack.pop();
                    chart[idx].deleted = false;
                    if(chart[idx].front != -1) chart[chart[idx].front].next = idx;
                    if(chart[idx].next != -1) chart[chart[idx].next].front = idx;
                    break;
            }
        }
        StringBuilder answer = new StringBuilder();
        for(int i=0; i<chart.length; i++){
            if(chart[i].deleted) answer.append("X");
            else answer.append("O");
        }
        return answer.toString();
    }

    // result
    public static void main(String[] args) {
        Solution solution = new Solution();
//        solution.solution();
//        TreeNode node = solution.solution();
//        System.out.println(solution.solution());
        System.out.println(Result.literal(solution.solution(n, k, cmd)));
//        System.out.println(Result.one_demension(solution.solution(places)));
//        System.out.println(Result.two_demension(solution.solution(dist)));
    }
}