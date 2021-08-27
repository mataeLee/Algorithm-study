import java.io.*;
import java.util.*;

public class Main{
    // 백준 백트래킹 연산자 끼워넣기 - 14888
    static int max = -1000000000;
    static int min = 1000000000;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        String[] str = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            nums[i] = Integer.parseInt(str[i]);
        }
        int[] cnt = new int[4]; // 0 = +, 1 = -, 2 = *, 3 = /
        str = br.readLine().split(" ");
        for(int i=0; i<4; i++){
            cnt[i] = Integer.parseInt(str[i]);
        }
        backtracking(nums[0],1, nums, cnt);
        StringBuilder sb = new StringBuilder();
        sb.append(max).append("\n").append(min);
        System.out.println(sb.toString());
    }

    private static void backtracking(int sum, int depth, int[] nums, int[] cnt) {
        if(depth == nums.length){
            if(sum > max) {
                max = sum;
            }
            if(sum < min){
                min = sum;
            }
            return;
        }
        for(int i=0; i<4; i++){
            if(cnt[i] != 0){
                cnt[i]--;
                switch (i){
                    case 0:
                        sum += nums[depth];
                        break;
                    case 1:
                        sum -= nums[depth];
                        break;
                    case 2:
                        sum *= nums[depth];
                        break;
                    case 3:
                        if(sum < 0){
                            sum = -(Math.abs(sum) / nums[depth]);
                            break;
                        }
                        sum /= nums[depth];
                        break;
                }
                backtracking(sum, depth+1, nums, cnt);
                switch (i){
                    case 0:
                        sum -= nums[depth];
                        break;
                    case 1:
                        sum += nums[depth];
                        break;
                    case 2:
                        sum /= nums[depth];
                        break;
                    case 3:
                        sum *= nums[depth];
                        break;
                }
                cnt[i]++;
            }
        }
    }
}