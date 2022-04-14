import java.io.*;
import java.util.*;

public class Main{
    // 백준 자료구조 카드2 - 2164
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<n ; i++){
            queue.add(i+1);
        }
        while (queue.size() > 1){
            queue.poll();
            queue.add(queue.poll());
        }
        System.out.println(queue.poll());
    }
}