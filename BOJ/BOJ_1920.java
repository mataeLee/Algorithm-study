import java.io.*;
import java.util.*;

public class Main{
    // 백준 이분탐색 수 찾기 - 1920
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] strs = br.readLine().split(" ");
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(strs[i]);
        }
        Arrays.sort(arr);

        int n2 = Integer.parseInt(br.readLine());
        int[] nums = new int[n2];
        strs = br.readLine().split(" ");
        for(int i=0; i<n2; i++){
            nums[i] = Integer.parseInt(strs[i]);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n2; i++){
            int num = nums[i];
            int left = 0;
            int right = n-1;
            boolean check = false;
            while (left <= right){
                int middle = (left+right)/2;
                if(arr[middle] == num) {
                    sb.append(1).append("\n");
                    check = true;
                    break;
                }
                else if(arr[middle] > num){
                    right = middle-1;
                }
                else{
                    left = middle+1;
                }
            }
            if(!check) sb.append(0).append("\n");
        }
        System.out.println(sb);
    }
}