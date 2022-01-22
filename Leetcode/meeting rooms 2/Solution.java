import java.util.*;

public class Solution {
    //test case
    static int[][] intervals = {{0, 30}, {5, 10}, {15, 20}};

    class Interval{
        int start;
        int end;

        Interval(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
    //algorithm solution
    public int minMeetingRooms(int[][] intervals) {
        List<Interval> list = new ArrayList<>();
        for(int i=0; i<intervals.length; i++){
            list.add(new Interval(intervals[i][0], intervals[i][1]));
        }
        // start 기준으로 오름차순 정렬
        Collections.sort(list, (a, b) -> a.start - b.start);

        // end 기준 min heap
        PriorityQueue<Interval> min_heap = new PriorityQueue<>((a, b) -> a.end - b.end);

        for(int i=0; i<list.size(); i++){
            Interval interval = list.get(i);
            if(!min_heap.isEmpty() && min_heap.peek().end <= interval.start) min_heap.poll();
            min_heap.add(interval);
        }

        return min_heap.size();
    }

    // result
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Result.literal(solution.minMeetingRooms(intervals)));
//        System.out.println(Result.one_demension(solution.solution(n, m, points, hands)));
//        System.out.println(Result.two_demension(solution.kClosest(points, k)));
    }
}