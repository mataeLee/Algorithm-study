import java.io.*;
import java.util.*;

public class Main {
    // 백준 자료구조 거짓말 - 1043
    static int[] parent;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strs = br.readLine().split(" ");
        int n = Integer.parseInt(strs[0]); // 사람 수
        boolean[] know = new boolean[n+1];

        int m = Integer.parseInt(strs[1]); // 파티 수
        int[][] partys = new int[m][];
        boolean[] party = new boolean[m];

        strs = br.readLine().split(" ");
        int answer = 0;
        for(int i=1; i<Integer.parseInt(strs[0])+1; i++){
            know[Integer.parseInt(strs[i])] = true; // 거짓말을 아는 사람
        }

        parent = new int[n+1];
        for(int i=0; i<n+1; i++){
            parent[i] = i;
        }

        for(int i=0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            partys[i] = new int[count];

            int idx = -1;
            for(int j=0; j<count; j++){
                int num = Integer.parseInt(st.nextToken());
                partys[i][j] = num;
                if(idx < 0 && know[num]){
                    idx = j;
                }
            }
            if(idx == -1){
                int val = partys[i][0];
                for(int j=1; j<count; j++){
                    union(val, partys[i][j]);
                }
            }
            else{
                party[i] = true;
                int val = partys[i][idx];
                for(int j=0; j<count; j++){
                    if(j == idx) continue;
                    union(val, partys[i][j]);
                }
            }
        }

        for(int i=0; i<m; i++){
            if(party[i]) continue;
            boolean lie = true;
            for(int j=0; j<partys[i].length; j++){
                if(know[find(partys[i][j])]) {
                    lie = false;
                    break;
                }
            }
            if(lie) answer++;
        }

        System.out.println(answer);
    }

    public static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a != b) parent[b] = a;
    }

    public static int find(int a){
        if(parent[a] == a) return a;
        else return parent[a] = find(parent[a]);
    }
}