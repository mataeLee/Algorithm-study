import java.util.*;

public class Solution {
    //test case
    static int[][] points = {{3, 3}, {5, -1}, {-2, 4}};
    static int k = 2;

    class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    //algorithm solution
    public int[][] kClosest(int[][] points, int k) {
        // max heap을 유지
        // k개만큼 넣고
        // 새로 들어온 point와 Max heap을 비교

        // quick select - 피벗을 뽑고 선택(그룹 나눠서 한쪽 버리기 사이즈를 비교) k 번째 까지 아이템을 뽑으라는 모든 문제에 적용 가능.
        // binary search - n만큼 도는 도중에 대충 중간지점을 뽑는다, 왼쪽 그룹 오른쪽 그룹으로 나누고 한쪽 그룹을 버린다.
        List<Point> list = new ArrayList<>();
        for(int i=0; i<points.length; i++){
            list.add(new Point(points[i][0], points[i][1]));
        }
        list = quick_select(list, k);
        int[][] answer = new int[k][2];
        for(int i=0; i<list.size(); i++){
            Point p = list.get(i);
            answer[i][0] = p.x;
            answer[i][1] = p.y;
        }
        return answer;
    }

    public List<Point> quick_select(List<Point> list, int k){
        if(list.size() == 0) return new ArrayList<>();
        List<Point> small = new ArrayList<>();
        List<Point> large = new ArrayList<>();

        Point pivot = list.get(0);
        int p_dis = pivot.x * pivot.x + pivot.y * pivot.y;

        for(int i=1; i<list.size(); i++){
            Point val = list.get(i);
            int val_dis = val.x * val.x + val.y * val.y;
            if(p_dis >= val_dis){
                small.add(val);
            }
            else large.add(val);
        }
        small.add(pivot);

        if(small.size() > k) return quick_select(small, k);
        else if(small.size() == k) return small;
        else {
            small.addAll(quick_select(large, k-small.size()));
            return small;
        }
    }

    // result
    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(Result.literal(solution.solution(n, m, points, hands)));
//        System.out.println(Result.one_demension(solution.solution(n, m, points, hands)));
        System.out.println(Result.two_demension(solution.kClosest(points, k)));
    }
}