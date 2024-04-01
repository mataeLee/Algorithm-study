import leetcode.TreeNode;

import java.util.*;

public class Solution {
    // 프로그래머스 카카오 거리두기 확인하기
    // 1시간 11분 소요

    //test case
    static String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
            {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
            {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
            {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
            {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};

    //algorithm solution
    public int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        char[][] map = new char[5][5];
        for(int i=0; i<places.length; i++){
            Queue<Point> persons = new LinkedList<>();
            for(int j=0; j<places.length; j++){
                String line = places[i][j];
                for(int k=0; k<places.length; k++){
                    char c = line.charAt(k);
                    map[j][k] = c;
                    if(c == 'P')persons.add(new Point(j, k));
                }
            }

            if(persons.isEmpty()) answer[i] = 1;
            boolean check = true;

            while (!persons.isEmpty()) {
                Point p = persons.poll();
                if (!bfs(map, p, map.length)) {
                    check = false;
                    break;
                }
            }
            if(check) answer[i] = 1;

        }
        return answer;
    }

    public boolean bfs(char[][] map, Point person, int m) {
        Queue<Point> heap = new LinkedList<>();
        heap.add(person);
        boolean[][] visited = new boolean[m][m];

        int dis = 1;
        while (!heap.isEmpty() && dis < 3) {
            int size = heap.size();
            for(int j=0; j<size; j++) {
                Point p = heap.poll();
                visited[p.x][p.y] = true;
                for (int i = 0; i < 4; i++) {
                    int x = p.x + dir[i][0];
                    int y = p.y + dir[i][1];
                    if (x < 0 || y < 0 || x == m || y == m || visited[x][y] || map[x][y] == 'X') continue;
                    if(map[x][y] == 'P') return false;
                    heap.add(new Point(x, y));
                }
            }
            dis++;
        }
        return true;
    }

    // result
    public static void main(String[] args) {
        Solution solution = new Solution();
//        solution.solution();
//        TreeNode node = solution.solution();
//        System.out.println(solution.solution());
//        System.out.println(Result.literal(solution.solution(lines)));
        System.out.println(Result.one_demension(solution.solution(places)));
//        System.out.println(Result.two_demension(solution.solution(dist)));
    }
}