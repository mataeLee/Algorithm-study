import java.io.*;
import java.util.*;

public class Main{
    // 백준 자료구조 구간 합 구하기 - 2042
    static long[] tree;
    
    static long[] data;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strs = br.readLine().split(" ");
        int n = Integer.parseInt(strs[0]);
        int m = Integer.parseInt(strs[1]);
        int k = Integer.parseInt(strs[2]);
        // 세그먼트 트리
        tree = new long[n*4+1];
        
        // 원본 데이터
        data = new long[n];
        
        // input
        for(int i=0; i<n; i++){
            data[i] = Long.parseLong(br.readLine());
        }
        
        // init
        init(0, n-1, 1);
        
        int count = 0;
        for(int i=0; i<m+k; i++) {
        	if(count == k) break;
        	String[] line = br.readLine().split(" ");
        	String a = line[0];
        	String b = line[1];
        	String c = line[2];
        	if("1".equals(a)) {
        		// update
        		int index = Integer.parseInt(b) - 1;
        		long diff = Long.parseLong(c) - data[index];
                // 트리 업데이트
        		update(0, n-1, 1, index, diff);
                // 원본 데이터 업데이트
        		data[index] += diff;
        	}
        	else if("2".equals(a)) {
        		count++;
        		// sum
        		long res = sum(0, n-1, 1, Integer.parseInt(b) - 1, Integer.parseInt(c)-1);
        		System.out.println(res);
        	}
        }
    }
    
    static long init(int start, int end, int node){
        if(start == end) return tree[node] = data[start];
        
        int mid = (start + end) / 2;
        
        return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
    }
    
    static long sum(int start, int end, int node, int left, int right) {
    	if(left > end || right < start) return 0;
    	
    	if(left <= start && right >= end) return tree[node];
    	
    	int mid = (start + end) / 2;
    	
    	return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
    }
    
    static void update(int start, int end, int node, int index, long diff) {
    	if(index < start || index > end) return;
    	
    	tree[node] += diff;
    	if(start == end) return;
    	
    	int mid = (start + end) / 2;
    	update(start, mid, node * 2, index, diff);
    	update(mid + 1 , end, node * 2 + 1, index, diff);       
    }
}
