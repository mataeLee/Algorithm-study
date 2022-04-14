import java.io.*;
import java.util.*;

public class Main {
    // 백준 자료구조 공항 - 10775
    static int[] parent;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;

        int g = Integer.parseInt(br.readLine());
        int p = Integer.parseInt(br.readLine());
        boolean[] gates = new boolean[g+1];
        parent = new int[g+1];
        for(int i=0; i<g+1; i++){
            parent[i] = i;
        }

        for(int i=0; i<p; i++){
            int gate = Integer.parseInt(br.readLine());
            if(find(gate) == 0) {
                break;
            }
            if(find(gate) == gate){
                union(gate-1, gate);
                gates[gate] = true;
            }
            else{
                gate = find(gate);
                union(gate-1, gate);
                gates[gate] = true;
            }

            answer++;
        }
        System.out.println(answer);
    }

    static int find(int a){
        if(parent[a] == a) return a;
        else return parent[a] = find(parent[a]);
    }
    static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a != b) parent[b] = a;
    }
}