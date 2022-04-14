import java.io.*;
import java.util.*;

public class Main{
    // 백준 자료구조 최대 힙 - 11279
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<n; i++){
            int arg = Integer.parseInt(br.readLine());
            if(arg == 0){
                if(heap.size() == 0) sb.append(0).append("\n");
                else sb.append(heap.poll()).append("\n");
            }
            else{
                heap.add(arg);
            }
        }
        System.out.println(sb);
    }
}