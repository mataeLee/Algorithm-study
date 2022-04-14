import java.io.*;
import java.util.*;

public class Main{
    // 백준 자료구조 가운데를 말해요 - 1655

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> max_heap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> min_heap = new PriorityQueue<>();

        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            int val = Integer.parseInt(br.readLine());

            // add
            if(max_heap.size() == 0){
                max_heap.add(val);
            }
            else if (val > max_heap.peek()) {
                min_heap.add(val);
            }
            else{
                max_heap.add(val);
            }

            // 밸런싱
            if(max_heap.size() - min_heap.size() > 1){
                min_heap.add(max_heap.poll());
            }
            if(min_heap.size() - max_heap.size() > 1){
                max_heap.add(min_heap.poll());
            }

            // res
            if(max_heap.size() == min_heap.size()) {
                sb.append(Math.min(max_heap.peek(), min_heap.peek()));
            }
            else if(max_heap.size() > min_heap.size()){
                sb.append(max_heap.peek());
            }
            else {
                sb.append(min_heap.peek());
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}