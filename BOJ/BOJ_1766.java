import java.io.*;
import java.util.*;

class Main{
    // 백준 문제집 위상정렬 - 1766

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] data = br.readLine().split(" ");

        int N = Integer.parseInt(data[0]);
        int M = Integer.parseInt(data[1]);

        int[] inDegree = new int[N+1];
        List<Integer>[] workbook = new List[N+1];
        for(int i=1; i<N+1; i++){
            workbook[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            data = br.readLine().split(" ");
            // A -> B
            int A = Integer.parseInt(data[0]);
            int B = Integer.parseInt(data[1]);
            inDegree[B]++;

            // 간선 정보 저장
            workbook[A].add(B);
        }

        Queue<Integer> queue = new PriorityQueue<>();

        for(int i=1; i<N+1; i++){
            if(inDegree[i] == 0) queue.add(i);
        }

        StringBuilder answer = new StringBuilder();

        while (queue.size() != 0){

            int val = queue.poll();

            answer.append(val).append(" ");

            for(int i=0; i<workbook[val].size(); i++){
                int des = workbook[val].get(i);
                inDegree[des]--;
                if(inDegree[des] == 0) queue.add(des);
            }
        }

        System.out.println(answer.toString().substring(0, answer.length()-1));
    }
}