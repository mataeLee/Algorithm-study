import java.io.*;
import java.util.*;

public class Main{
	// 백준 덱 2 - 28279 실버4
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int n = Integer.parseInt(br.readLine());
    	
    	int[] dq = new int[n+1];
    	
    	int front = n+1;
    	int rear = n+1;
    	
    	StringBuilder sb = new StringBuilder();
    	
    	for(int i=0; i<n; i++) {
    		String[] data = br.readLine().split(" ");
    		switch(data[0]) {
    		case "1":
    			dq[front--%(n+1)] = Integer.parseInt(data[1]);
    			break;
    		case "2":    			
    			dq[++rear%(n+1)] = Integer.parseInt(data[1]);
    			break;
    		case "3":
    			if(front%(n+1) != rear%(n+1)) {
    				sb.append(dq[++front%(n+1)]);
    			}
    			else {
    				sb.append(-1);
    			}
    			sb.append("\n");
    			break;
    		case "4":
    			if(front%(n+1) != rear%(n+1)) {
    				sb.append(dq[rear--%(n+1)]);
    			}
    			else {
    				sb.append(-1);
    			}
    			sb.append("\n");
    			break;
    		case "5":
    			int fIdx = front%(n+1);
    			int rIdx = rear%(n+1);
    			if(fIdx == rIdx) sb.append(0);
    			else sb.append((fIdx > rIdx)? (n+1) - (fIdx - rIdx) : rIdx - fIdx);
    			sb.append("\n");
    			break;
    		case "6":
    			if(front%(n+1) == rear%(n+1)) sb.append(1);
    			else sb.append(0);
    			sb.append("\n");
    			break;
    		case "7":
    			if(front%(n+1) != rear%(n+1)) {
    				sb.append(dq[(front+1)%(n+1)]);
    			}
    			else {
    				sb.append(-1);
    			}
    			sb.append("\n");
    			break;
    		case "8":
    			if(front%(n+1) != rear%(n+1)) {
    				sb.append(dq[rear%(n+1)]);
    			}
    			else {
    				sb.append(-1);
    			}
    			sb.append("\n");
    			break;
    		}
    	}
    	
    	System.out.println(sb.toString());
    }
}