import java.util.*;

public class Main {
    // 프로그래머스 Lv.3 야근지수

    //test case
    static int n = 3;
    static int[] works = {5, 1, 7};

    //algorithm solution
    static class Solution {
        public long solution(int n, int[] works) {
            long answer = 0;
            Arrays.sort(works);
            if(works.length == 1){
                works[0] -= n;
                if(works[0] > 0) return works[0] * works[0];
                else return 0;
            }
            int idx = works.length-2;
            while(n>0){
                if(idx > 0 && works[idx] < works[idx-1]) {
                    idx--;
                }else{
                    idx = works.length-2;
                }
                if(works[idx] > works[works.length-1]){
                    works[idx]--;
                }else{
                    works[works.length-1]--;
                }
                n--;
            }
            for(int i=0; i<works.length; i++){
                if(works[i] > 0) answer += works[i] * works[i];
            }
            return answer;
        }
    }

    // result
    public static void main(String[] args) {
        Solution solution = new Solution();
        long answer = solution.solution(n, works);
//        System.out.print("[");
//        for(int i=0; i<answer.length; i++){
//            System.out.print("["+answer[i][0]+", "+answer[i][1]+"]");
//            if(i < answer.length - 1) System.out.print(", ");
//        }
//      System.out.print("]");
        System.out.println(answer);
    }
}