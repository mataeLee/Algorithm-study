import java.io.*;
import java.util.*;

public class Main{
    // 백준 자료구조 구간 합 구하기 - 2042
    static long[] tree;
    static long[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strs = br.readLine().split(" ");
        int n = Integer.parseInt(strs[0]);
        int m = Integer.parseInt(strs[1]);
        int k = Integer.parseInt(strs[2]);
        tree = new long[n*4+1];
        arr = new long[n];
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<arr.length; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        init(0, n-1, 1);
        for(int i=0; i<m+k; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            if(a == 1){
                update(0, n-1, 1, b-1, (long)c - arr[b-1]);
                arr[b-1] = c;
            }
            else{
                sb.append(sum(0, n-1, 1, b-1, (int)c-1)).append("\n");
            }
        }

        System.out.println(sb);
    }
    static long init(int start, int end, int node){
        if(start == end) return tree[node] = arr[start];
        int mid = (start + end) / 2;
        return tree[node] = init(start, mid, node*2) + init(mid + 1, end, node*2+1);
    }

    static long sum(int start, int end, int node, int left, int right){
        if(left > end || right < start) return 0;
        if(left <= start && end <= right) return tree[node];
        int mid = (start + end) / 2;
        return sum(start, mid, node *2, left, right) + sum(mid+1, end, node*2+1, left, right);
    }

    static void update(int start, int end, int node, int index, long dif){
        if(index < start || index > end) return;
        tree[node] += dif;
        if(start == end) return;
        int mid = (start + end) / 2;
        update(start, mid, node*2, index, dif);
        update(mid + 1, end, node*2+1, index, dif);
    }
}