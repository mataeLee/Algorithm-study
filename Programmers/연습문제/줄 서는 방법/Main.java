import java.util.*;

public class Main {
    // 프로그래머스 Lv.3 줄 서는 방법

    //test case
    static int n = 4;
    static long k = 5;

    //algorithm solution
    static class Solution {
        public List<Integer> solution(int n, long k) {
            List<Integer> answer = new ArrayList<>();
            long[] mem = new long[n+1];
            mem[0] = 1;
            for(int i=1; i<=n; i++){
                mem[i] = mem[i-1] * i;
            }
            int[] nArr = new int[n+1];
            for(int i=1; i<=n; i++){
                nArr[i] = 1;
            }
            while (true){
                if(k==0){
                    for(int j=0; j<nArr.length; j++){
                        if(nArr[nArr.length-j-1] != 0)
                            answer.add(nArr.length-j-1);
                    }
                    return answer;
                }
                if(k==1) {
                    for (int j = 0; j < nArr.length; j++) {
                        if (nArr[j] != 0)
                            answer.add(j);
                    }
                    return answer;
                }
                int num = (int)(k/mem[n-1]);
                if(k % mem[n-1] != 0){
                    num++;
                }
                int cnt = 0; // num 번째의 수 선택
                for(int i=1; i<nArr.length; i++){
                    if(nArr[i] != 0) {
                        cnt++;
                        if(cnt == num){
                            answer.add(i);
                            nArr[i] = 0;
                        }
                    }
                }
                k =  k - mem[n-1]*(num-1);
                n--;
            }
        }
    }

    // result
    public static void main(String[] args) {
        Solution solution = new Solution();
        List answer = solution.solution(n, k);

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