import java.io.*;
import java.util.*;

public class Main{
    // 백준 자료구조 큐 - 10845
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            String[] str = br.readLine().split(" ");
            switch (str[0]){
                case "push":
                    queue.add(Integer.parseInt(str[1]));
                    break;
                case "pop":
                    if(!queue.isEmpty()){
                        sb.append(queue.poll()).append("\n");
                    }else {
                        sb.append(-1).append("\n");
                    }
                    break;
                case "size":
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty":
                    if(queue.isEmpty()){
                        sb.append(1).append("\n");
                    }else {
                        sb.append(0).append("\n");
                    }
                    break;
                case "front":
                    if(!queue.isEmpty()){
                        sb.append(queue.getFirst()).append("\n");
                    }else {
                        sb.append(-1).append("\n");
                    }
                    break;
                case "back":
                    if(!queue.isEmpty()){
                        sb.append(queue.getLast()).append("\n");
                    }else {
                        sb.append(-1).append("\n");
                    }
                    break;
                default:
                    break;
            }
        }
        System.out.println(sb);
    }
}