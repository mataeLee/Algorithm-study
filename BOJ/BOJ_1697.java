import java.io.*;
import java.util.*;

public class Main {
    // 백준 그래프 숨바꼭질 - 1697

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");

        int n = Integer.parseInt(strs[0]);
        int k = Integer.parseInt(strs[1]);

        if(n >= k){
            System.out.println(n - k);
            return;
        }

        int arr[] = new int[Math.max(n, k)*2+1];
        arr[n] = -1;

        int answer = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);

        while (queue.size() > 0){
            answer++;
            int len = queue.size();
            for(int i=0; i<len; i++){
                int val = queue.poll();
                int left = val-1;
                int right = val+1;
                int teleport = val*2;
                if(left > -1 && arr[left] == 0){
                    arr[left] = answer;
                    queue.add(left);
                }
                if(right < arr.length && arr[right] == 0){
                    arr[right] = answer;
                    queue.add(right);
                }
                if(teleport < arr.length && arr[teleport] == 0){
                    arr[teleport] = answer;
                    queue.add(teleport);
                }
            }
        }
        System.out.println(arr[k]);
    }
}