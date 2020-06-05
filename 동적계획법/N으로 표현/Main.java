import java.util.*;

public class Main {

    // test case
    static int N = 4;
    static int number = 17;

    // algorithm solution
    static class Solution {
        public int solution(int N, int number) {
            int[][] dp = new int[8][];
            int[] mem = new int[32001];
            dp[0] = new int[1];
            dp[0][0] = N; // 숫자 1개 사용
            mem[N] = 1; // 가능한 숫자 메모이제이션
            for (int i = 1; i < 9; i++) {
                if (mem[number] == 1) return i;
                dp[i] = new int[(int) Math.pow(6, i)*i + 1];
                StringBuilder sb = new StringBuilder();
                sb.append(N);
                sb.append(dp[i - 1][0]);
                if (Integer.parseInt(sb.toString()) <= 32000) {
                    dp[i][0] = Integer.parseInt(sb.toString());
                    mem[Integer.parseInt(sb.toString())] = 1;
                }
                dp(i, dp, mem);
            }
            return -1;
        }

        public void dp(int depth, int[][] dp, int[] mem) {
            int idx = 1;
            for (int i = 0; i < depth; i++) {
                for (int j = i; j < depth; j++) {
                    if (i + j + 2 == depth + 1) { // 괄호 처
                        for (int k = 0; k < dp[i].length; k++) {
                            for (int l = 0; l < dp[j].length; l++) {
                                int num1 = dp[i][k];
                                int num2 = dp[j][l];
                                if(num1 != 0 && num2 != 0) {
                                    if (num1 + num2 <= 32000) {
                                        mem[num1 + num2] = 1;
                                        dp[depth][idx++] = num1 + num2;
                                    }
                                    if (num1 > num2) {
                                        mem[num1 - num2] = 1;
                                        dp[depth][idx++] = num1 - num2;
                                    }
                                    if (num1 * num2 <= 32000) {
                                        mem[num1 * num2] = 1;
                                        dp[depth][idx++] = num1 * num2;
                                    }
                                    if (num2 > 0) {
                                        mem[num1 / num2] = 1;
                                        dp[depth][idx++] = num1 / num2;
                                    }
                                    if (num2 > num1) {
                                        mem[num2 - num1] = 1;
                                        dp[depth][idx++] = num2 - num1;
                                    }
                                    if (num1 > 0) {
                                        mem[num2 / num1] = 1;
                                        dp[depth][idx++] = num2 / num1;
                                    }
                                }
                            }

                        }
                    }
                }
            }
        }
    }

    // result
    public static void main(String[] args) {
        Solution solution = new Solution();
        int answer = solution.solution(N, number);
        System.out.println(answer);
    }
}