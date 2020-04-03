import java.util.*;

public class Main {
    // test case
    static String number = "11111";
    static int k = 2;

    // algorithm solution
    static class Solution {
        static String answer;
        public String solution(String number, int k) {
            answer = "0";

            int r = number.length() - k;
            int arr[] = new int[number.length()];

            for(int i=0; i<number.length(); i++){
                StringBuilder sb = new StringBuilder();
                arr[i] = Integer.parseInt(sb.append(number.charAt(i)).toString());
            }
            int []output = new int[number.length()];
            combination(arr, output, number.length(), r, 0, 0);
            return answer.trim();
        }

        public void combination(int[] arr, int[] output, int n, int r, int index, int target){
            if(r == 0){
                StringBuilder sb = new StringBuilder();
                for(int i=0; i<index; i++){
                    sb.append(arr[output[i]]);
                }
                if(Long.parseLong(answer) < Long.parseLong(sb.toString()))
                    answer = sb.toString();
            }else if(target == n) return;
            else{
                output[index] = target;
                combination(arr, output, n, r-1, index+1, target+1); // (i)
                combination(arr, output, n, r, index, target+1); //(ii)
            }
        }
    }
    // result
    public static void main(String[] args) {
        Solution solution = new Solution();
        String answer = solution.solution(number, k);
        System.out.println(answer);
    }
}
