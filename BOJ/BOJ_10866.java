import java.io.*;
import java.util.*;

public class Main{
    // 백준 자료구조 덱 - 10866
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            String[] str = br.readLine().split(" ");
            switch (str[0]){
                case "push_front":
                    deque.addFirst(Integer.parseInt(str[1]));
                    break;
                case "push_back":
                    deque.addLast(Integer.parseInt(str[1]));
                    break;
                case "pop_front":
                    if(deque.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(deque.pollFirst()).append("\n");
                    break;
                case "pop_back":
                    if(deque.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(deque.pollLast()).append("\n");
                    break;
                case "size":
                    sb.append(deque.size()).append("\n");
                    break;
                case "empty":
                    if(deque.isEmpty()) sb.append(1).append("\n");
                    else sb.append(0).append("\n");
                    break;
                case "front":
                    if(deque.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(deque.getFirst()).append("\n");
                    break;
                case "back":
                    if(deque.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(deque.getLast()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}