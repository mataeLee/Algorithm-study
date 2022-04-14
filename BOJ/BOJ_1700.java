import java.io.*;
import java.util.*;

public class Main {
    // 백준 그리디 멀티탭 스케쥴링 - 1700

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strs = br.readLine().split(" ");
        int n = Integer.parseInt(strs[0]);
        int k = Integer.parseInt(strs[1]);

        strs = br.readLine().split(" ");

        Set<Integer> tap = new HashSet<>();
        PriorityQueue<Integer>[] heap = new PriorityQueue[k+1];
        heap[0] = new PriorityQueue<>();
        heap[0].add(0);

        for(int i=0; i<k; i++){
            heap[i+1] = new PriorityQueue<>();
        }

        int[] order = new int[k];
        for(int i=0; i<k; i++){
            int num = Integer.parseInt(strs[i]);
            heap[num].add(i);
            order[i] = num;
        }

        int answer = 0;

        for(int i=0; i<k; i++){
            int num = order[i];
            if(!tap.contains(num) && tap.size() < n){
                tap.add(num);
            }
            else if(!tap.contains(num) && tap.size() == n){
                int max = 0;
                for(int val : tap){
                    if(heap[val].isEmpty()){
                        max = val;
                        break;
                    }
                    if(heap[val].peek() > heap[max].peek()) max = val;
                }
                tap.remove(max);
                tap.add(num);
                answer++;
            }
            heap[num].poll();
        }
        System.out.println(answer);
    }
}