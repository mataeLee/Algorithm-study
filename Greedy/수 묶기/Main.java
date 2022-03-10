import java.io.*;
import java.util.*;

public class Main {
    // 백준 그래프 수 묵기 - 1744

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());


        PriorityQueue<Integer> pos = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> neg = new PriorityQueue<>();

        for(int i=0; i<n; i++){
            int num = Integer.parseInt(br.readLine());
            if(num > 0) pos.add(num);
            else neg.add(num);
        }

        int answer = 0;

        while (!pos.isEmpty()){
            int num1 = pos.poll();
            if(pos.size() == 0){
                answer += num1;
                break;
            }
            if(num1 == 1){
                answer += num1;
                continue;
            }
            int num2 = pos.poll();
            answer += num1 * num2;
        }

        while (!neg.isEmpty()){
            int num1 = neg.poll();
            if(neg.size() == 0){
                answer += num1;
                break;
            }
            int num2 = neg.poll();
            answer += num1 * num2;
        }

        System.out.println(answer);
    }
}