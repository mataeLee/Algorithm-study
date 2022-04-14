import java.io.*;
import java.util.*;

public class Main{
    // 백준 자료구조 카드 정렬하기 - 1715
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int i=0; i<n; i++){
            heap.add(Integer.parseInt(br.readLine()));
        }
        int sum = 0;
        while (heap.size() > 1){
            int a = heap.poll();
            int b = heap.poll();
            sum += a+b;
            heap.add(a+b);
        }
        System.out.println(sum);
    }
}