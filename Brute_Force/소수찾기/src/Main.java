import java.util.*;

import static jdk.nashorn.internal.objects.Global.print;

public class Main {

    // test case
    static String numbers = "17";

    // algorithm solution
    static class Solution {
        static int answer = 0;
        static Map<Integer, Boolean> hash = new HashMap<>();

        public int solution(String numbers) {

            int []arr = new int[numbers.length()];
            for(int i=0; i<numbers.length(); i++){
                arr[i] = Integer.parseInt(numbers.charAt(i)+"");
            }
            boolean [] visited = new boolean[arr.length];
            int[] output = new int[arr.length];
            for(int i=numbers.length(); i>=1; i--){

                permutation(arr, output, visited, 0, arr.length, i);
            }
            System.out.println(hash);
            return answer;
        }
        static void permutation(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
            if (depth == r) {
                StringBuilder num = new StringBuilder("");
                for(int i=0; i<r; i++){
                    num.append(output[i]);
                }
                int tmp = Integer.parseInt(num.toString());
                if(hash.get(tmp) == null) {
                    if (prime(tmp))
                        answer++;
                    hash.put(tmp, true);
                }
                return;
            }

            for (int i=0; i<n; i++) {
                if (visited[i] != true) {
                    visited[i] = true;
                    output[depth] = arr[i];
                    permutation(arr, output, visited, depth + 1, n, r);
                    output[depth] = 0; // 이 줄은 없어도 됨
                    visited[i] = false;;
                }
            }
        }

        public static boolean prime(int num){
            if(num < 2) return false;
            else if(num == 2) return true;
            else {
                for (int i = 2; i < num; i++) {
                    if (num % i == 0)
                        return false;
                }
                return true;
            }
        }
    }

    // result
    public static void main(String[] args) {
        Solution solution = new Solution();
        int answer = solution.solution(numbers);
        System.out.println(answer);
    }
}