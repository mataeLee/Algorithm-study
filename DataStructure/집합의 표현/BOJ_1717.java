import java.io.*;
import java.util.*;

public class Main{
    // 백준 자료구조 집합의 표현 - 1717
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strs = br.readLine().split(" ");
        int n = Integer.parseInt(strs[0]);
        int m = Integer.parseInt(strs[1]);
        arr =  new int[n+1];
        for(int i=0; i<arr.length; i++){
            arr[i] = i;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<m; i++){
            strs = br.readLine().split(" ");
            int a = Integer.parseInt(strs[1]);
            int b = Integer.parseInt(strs[2]);
            if(strs[0].equals("0")){
                union(a, b);
            }
            else {
                if(find(a) == find(b)) sb.append("YES").append("\n");
                else sb.append("NO").append("\n");
            }
        }
        System.out.println(sb);
    }

    static int find(int a){
        if(arr[a] == a)
            return a;
        else
            return arr[a] = find(arr[a]);
    }

    static void union(int a, int b){
        a = find(a);
        b = find(b);
        arr[b] = a;
    }
}