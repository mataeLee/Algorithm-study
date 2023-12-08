import java.io.*;
import java.util.*;

public class Main{
	// 백준 queuestack - 24511 실버3
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int n = Integer.parseInt(br.readLine());
    	
    	long[] queue = new long[200000];
    	int front = -1;
    	int rear = -1;
    	
    	int index = 0;
    	String[] ds = br.readLine().split(" ");
    	String[] data = br.readLine().split(" ");
    	for(int i=n-1; i>=0; i--) {
    		if("0".equals(ds[i])) {
    			queue[index++] = Long.parseLong(data[i]);
    		}
    	}
    	rear = index;
    	
    	int m = Integer.parseInt(br.readLine());
    	data = br.readLine().split(" ");
    	
    	StringBuilder sb = new StringBuilder();
    	for(int i=0; i<m; i++) {
    		queue[rear++] = Long.parseLong(data[i]);
    		sb.append(queue[++front]).append(" ");
    	}
    	System.out.println(sb.toString());
    }
}