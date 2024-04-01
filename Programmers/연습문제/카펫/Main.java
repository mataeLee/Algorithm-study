import java.util.*;

public class Main {

    // test case
    static int brown = 24;
    static int red = 24;

    // algorithm solution
    static class Solution {
        public int[] solution(int brown, int red) {
            int[] answer = new int[2];

            List<Integer> aliquots = new ArrayList<>();
            // red 박스의 인수들 구하기
            for(int i=1; i<=red; i++){
                if(red%i==0)
                    aliquots.add(i);
            }
            int x = 0;
            int y = 0;
            if(aliquots.size()>1) {
                for (int i = aliquots.size() / 2; i < aliquots.size(); i++) {
                    x = aliquots.get(i) + 2;
                    y = aliquots.get(aliquots.size() - i - 1) + 2;

                    if (brown + red == x * y) {
                        break;
                    }
                }
            }
            else {
                x = aliquots.get(0) + 2;
                y = aliquots.get(0) + 2;
            }
            answer[0] = x;
            answer[1] = y;
            return answer;
        }
    }


    // result
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] answer = solution.solution(brown, red);
        System.out.print("[");
        for(int i=0; i<answer.length; i++){
            System.out.print(answer[i]);
            if(i<answer.length-1)
                System.out.print(", ");
        }
        System.out.print("]");
    }
}