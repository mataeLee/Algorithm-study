import java.io.*;
import java.util.*;

public class Main{
	// 백준 큐2 - 18258 실버4
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int n = Integer.parseInt(br.readLine());
    	
    	int[] q1 = new int[n+1];
    	int front = -1;
    	int rear = -1;
    	
    	StringBuilder sb = new StringBuilder();

    	for(int i=0; i<n; i++) {
    		String[] data = br.readLine().split(" ");
    		switch(data[0]) {
    		case "push":
    			q1[++rear] = Integer.parseInt(data[1]);
    			if(rear == 0) front = 0;
    			break;
    		case "pop":
    			if(rear < 0 || front > rear) sb.append(-1);
    			else {
    				sb.append(q1[front++]);
    			}
    			sb.append("\n");
    			break;
    		case "size":
    			if(rear < 0 || front > rear)
    				sb.append(0);
    			else sb.append(rear - front + 1);
    			sb.append("\n");
    			break;
    		case "empty":
    			if(rear < 0 || front > rear) sb.append(1);
    			else sb.append(0);
    			sb.append("\n");
    			break;
    		case "front":
    			if(rear < 0 || front > rear)  sb.append(-1);
    			else sb.append(q1[front]);
    			sb.append("\n");
    			break;
    		case "back":
    			if(rear < 0 || front > rear) sb.append(-1);
    			else sb.append(q1[rear]);
    			sb.append("\n");
    			break;
    		}
    	}
    	System.out.println(sb.toString());
    }
}