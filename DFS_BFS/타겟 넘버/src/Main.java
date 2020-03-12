import java.util.*;
public class Main {

    // test case
    static int [] numbers = {1, 1, 1, 1, 1};
    static int target = 3;

    // algorithm solution
    static class Solution {
        static int answer=0;
        public int solution(int[] numbers, int target) {
            int sum=0;
            dfs(1,numbers,0,target,sum);
            dfs(0,numbers,0,target,sum);
            return answer;
        }

        public void dfs(int cal, int []numbers, int idx,int target, int sum){

            if(idx >= numbers.length) {
                return;
            }
            else {
                if(cal == 1)
                    sum += numbers[idx];
                else
                    sum += -numbers[idx];
                idx += 1;
                if(idx >= numbers.length) {
                    if (sum == target){
                        answer++;
                    }
                    return;
                }
                dfs(1,numbers,idx,target,sum);
                dfs(0,numbers,idx,target,sum);

            }
        }
    }

    // result
    public static void main(String[] args) {
        Solution solution = new Solution();
        int answer = solution.solution(numbers, target);
        System.out.println(answer);
    }
}