import java.io.*;
import java.util.*;

public class Main{
    // 백준 자료구조 절대값 힙 - 11286
    static class Number implements Comparable<Number>{
        int val;
        int abs;

        public Number(int num) {
            this.val = num;
            this.abs = Math.abs(num);
        }

        @Override
        public int compareTo(Number o) {
            if(abs == o.abs) return val - o.val;
            return abs - o.abs;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Number> heap = new PriorityQueue<>();

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n; i++){
            int num = Integer.parseInt(br.readLine());
            if(num != 0) {
                Number number = new Number(num);
                heap.add(number);
            }
            else{
                if(heap.size() > 0)
                    sb.append(heap.poll().val).append("\n");
                else sb.append(0).append("\n");
            }
        }
        System.out.println(sb);
    }
}