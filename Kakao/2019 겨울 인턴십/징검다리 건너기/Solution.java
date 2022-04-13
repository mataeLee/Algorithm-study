import java.util.*;

public class Solution {
    // 프로그래머스 Lv.3 징검다리 건너기

    //test case
    static int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
    static int k = 3;

    //algorithm solution
    public int solution(int[] stones, int k) {
        // 이진탐색
        int max = 0;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<stones.length; i++){
            if(stones[i] < min) min = stones[i];
            if(stones[i] > max) max = stones[i];
        }
        while(min <= max){
            int mid = (max+min)/2;
            int cnt = 0;
            boolean check = true;
            for(int i=0; i<stones.length; i++){
                if(stones[i] <= mid) cnt++;
                else cnt = 0;
                if(cnt == k) {
                    max = mid-1;
                    check = false;
                    break;
                }
            }
            if(check){
                min = mid+1;
            }
        }
        return min;
    }


    // result
    public static void main(String[] args) {
        Solution solution = new Solution();
        int answer = solution.solution(stones, k);

        // 상수, 제너릭컬렉션
        System.out.println(answer);
    // 1차원 배열
//        System.out.print("[");
//        for(int i=0; i<answer.length; i++){
//            System.out.print(answer[i]);
//            if(i < answer.length - 1) System.out.print(", ");
//        }
//        System.out.print("]");

    // 2차원 배열
//        System.out.print("[");
//        for(int i=0; i<answer.length; i++){
//            System.out.print("["+answer[i][0]+", "+answer[i][1]+"]");
//            if(i < answer.length - 1) System.out.print(", ");
//        }
//      System.out.print("]");
    }
}