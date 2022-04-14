import java.io.*;
import java.util.*;

public class Main {
    // 백준 자료구조 외계인의 기타연주 - 2841

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strs = br.readLine().split(" ");
        int n = Integer.parseInt(strs[0]);
        int p = Integer.parseInt(strs[1]);

        PriorityQueue<Integer>[] guitar = new PriorityQueue[6];
        for(int i=0; i<6; i++){
            guitar[i] = new PriorityQueue(Collections.reverseOrder());
        }

        int answer = 0;
        for(int i=0; i<n; i++){
            strs = br.readLine().split(" ");
            int line = Integer.parseInt(strs[0]);
            int pret = Integer.parseInt(strs[1]);
            while (!guitar[line].isEmpty() && guitar[line].peek() > pret){
                guitar[line].poll();
                answer++;
            }
            if(guitar[line].isEmpty()){
                guitar[line].add(pret);
                answer++;
                continue;
            }
            if(guitar[line].peek() < pret){
                guitar[line].add(pret);
                answer++;
            }
        }
        System.out.println(answer);
    }
}