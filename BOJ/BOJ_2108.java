import java.io.*;
import java.util.*;

public class Main {
    // 백준 구현 통계학 - 2108

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] count = new int[8001];
        double sum = 0;

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        List<Integer> list = new ArrayList<>();

        int max = -4001;
        int min = 4001;
        for(int i=0; i<n; i++){
            int num = Integer.parseInt(br.readLine());
            list.add(num);
            sum += num;
            count[num+4000]++;
            if(min > num) min = num;
            if(max < num) max = num;
        }
        Collections.sort(list);
        // 산술평균
        System.out.println(Math.round(sum/n));
        // 중앙값
        System.out.println(list.get(list.size()/2));
        // 최빈값
        int max_count = 0;
        for(int i=0; i<count.length; i++){
            if(count[i] == 0) continue;
            if(count[i] == max_count){
                heap.add(i-4000);
            }
            if(count[i] > max_count){
                heap = new PriorityQueue<>();
                heap.add(i-4000);
                max_count = count[i];
            }
        }
        if(heap.size() > 1){
            heap.poll();
            System.out.println(heap.poll());
        }else{
            System.out.println(heap.poll());
        }
        // 범위
        System.out.println(max - min);
    }
}