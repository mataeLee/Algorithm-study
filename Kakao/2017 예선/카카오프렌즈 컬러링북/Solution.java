import leetcode.TreeNode;

import java.util.*;

public class Solution {
    // 프로그래머스 카카오 카카오프렌즈 컬러링북

    //test case
    static int m = 6;
    static int n = 4;
    static int[][] picture = {{1, 1, 1, 0},
            {1, 2, 2, 0},
            {1, 0, 0, 1},
            {0, 0, 0, 1},
            {0, 0, 0, 3},
            {0, 0, 0, 3}};

    //algorithm solution
    public boolean[][] visited = new boolean[m][n];
    public int area = 0;
    public int[] solution(int m, int n, int[][] picture) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j] && picture[i][j] != 0){
                    area = 0;
                    area(picture, i, j, m, n, picture[i][j]);
                    heap.add(area);
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = heap.size();
        answer[1] = heap.poll();
        return answer;
    }

    private void area(int[][] picture, int i, int j, int m, int n, int val) {
        if(i < 0 || j < 0 || i == m || j == n || picture[i][j] != val || picture[i][j] == 0 || visited[i][j]) return;
        visited[i][j] = true;
        area++;
        area(picture, i+1, j, m, n, val);
        area(picture, i-1, j, m, n, val);
        area(picture, i, j+1, m, n, val);
        area(picture, i, j-1, m, n, val);
    }

    // result
    public static void main(String[] args) {
        Solution solution = new Solution();
//        solution.solution();
//        TreeNode node = solution.solution();
//        System.out.println(solution.solution());
//        System.out.println(Result.literal(solution.solution(lines)));
        System.out.println(Result.one_demension(solution.solution(m, n, picture)));
//        System.out.println(Result.two_demension(solution.solution(dist)));
    }
}