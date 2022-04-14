import java.io.*;
import java.util.*;

public class Main{
    // 백준 자료구조 최솟값 - 10868
    static int[] tree;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        int n = Integer.parseInt(strs[0]);
        tree = new int[n*4];
        arr = new int[n];
        int m = Integer.parseInt(strs[1]);
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        for(int i=0; i<n*4; i++){
            tree[i] = Integer.MAX_VALUE;
        }
        init(0, n-1, 1);
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<m; i++){
            strs = br.readLine().split(" ");
            int a = Integer.parseInt(strs[0]);
            int b = Integer.parseInt(strs[1]);
            sb.append(min(0, n-1, 1, a-1, b-1)).append("\n");
        }
        System.out.println(sb);
    }

    public static int init(int start, int end, int node){
        if(start == end) return tree[node] = arr[start];
        int mid = (start+end) / 2;
        return tree[node] = Math.min(init(start, mid, node*2), init(mid+1, end, node*2+1));
    }

    public static int min(int start, int end, int node, int left, int right){
        if(left > end || right < start) return Integer.MAX_VALUE;

        if(left <= start && right >= end) return tree[node];

        int mid = (start+end)/2;

        return Math.min(min(start, mid, node*2, left, right), min(mid+1, end, node*2+1, left, right));
    }

}