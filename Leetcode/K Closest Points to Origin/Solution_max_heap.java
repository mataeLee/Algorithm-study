import java.util.*;

public class Solution {
    //test case
    static int[][] points = {{1, 3}, {2, -2}};
    static int k = 1;

    class Point implements Comparable<Point>{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            return (o.x * o.x + o.y * o.y) - (this.x * this.x + this.y * this.y);
        }
    }
    //algorithm solution
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> max_heap = new PriorityQueue<>();

        for(int i=0; i<points.length; i++){
            int x = points[i][0];
            int y = points[i][1];
            int len = x * x + y * y;
            if(max_heap.size() < k) max_heap.add(new Point(x, y));
            else{
                Point val = max_heap.peek();
                int val_len = val.x * val.x + val.y * val.y;
                if(val_len > len){
                    max_heap.poll();
                    max_heap.add(new Point(x, y));
                }
            }
        }
        int[][] answer = new int[k][2];
        for(int i=0; i<k; i++){
            Point p = max_heap.poll();
            answer[i][0] = p.x;
            answer[i][1] = p.y;
        }
        return answer;
    }

    // result
    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(Result.literal(solution.solution(n, m, points, hands)));
//        System.out.println(Result.one_demension(solution.solution(n, m, points, hands)));
        System.out.println(Result.two_demension(solution.kClosest(points, k)));
    }
}