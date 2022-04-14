import java.io.*;
import java.util.*;

public class Main {
    // 백준 구현 치킨 배달 - 15686
    static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static PriorityQueue<Integer> res = new PriorityQueue<>();
    static int[][] distance;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        int n = Integer.parseInt(strs[0]);
        int m = Integer.parseInt(strs[1]);

        List<Point> chickens = new ArrayList<>();
        List<Point> houses = new ArrayList<>();

        for(int i=0; i<n; i++){
            String[] line = br.readLine().split(" ");
            for(int j=0; j<n; j++){
                int val = Integer.parseInt(line[j]);
                if(val == 1){
                    houses.add(new Point(i, j));
                }
                else if(val == 2){
                    chickens.add(new Point(i, j));
                }
            }
        }
        distance = new int[houses.size()][chickens.size()];
        for(int i=0; i<houses.size(); i++){
            Point house = houses.get(i);
            for(int j=0; j<chickens.size(); j++){
                Point chicken = chickens.get(j);
                distance[i][j] = Math.abs(chicken.x - house.x) + Math.abs(chicken.y - house.y);
            }
        }
        int[] out = new int[m];
        boolean[] visited = new boolean[chickens.size()];
        back_tracking(houses, chickens, out, n, m, 0, visited);
        System.out.println(res.poll());
    }

    private static void back_tracking(List<Point> houses, List<Point> chickens, int[] out, int n, int m, int level, boolean[] visited) {
        if(level == m){
            int ans = 0;
            for(int i=0; i<houses.size(); i++){
                int min = n+n;
                for(int j=0; j<m; j++){
                    if(min > distance[i][out[j]]) min = distance[i][out[j]];
                }
                ans += min;
            }
            res.add(ans);
            return;
        }
        for(int i=0; i<chickens.size(); i++){
            if(level > 0 && out[level-1] > i) continue;
            if(visited[i]) continue;
            out[level] = i;
            visited[i] = true;
            back_tracking(houses, chickens, out, n, m, level+1, visited);
            visited[i]= false;
        }
    }
}