import java.io.*;
import java.util.*;

public class Main{
	// 백준 스택2 - 28278 실버4
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int n = Integer.parseInt(br.readLine());
    	
    	int[] st = new int[1000000];
    	int top = -1;
    	StringBuilder sb = new StringBuilder();
    	
    	for(int i=0; i<n; i++) {
    		String[] data = br.readLine().split(" ");
    		switch(data[0]) {
    		case "1":
    			st[++top] = Integer.parseInt(data[1]);
    			break;
    		case "2":
    			if(top > -1) sb.append(st[top--]);
    			else sb.append(-1);
    			sb.append("\n");
    			break;
    		case "3":
    			sb.append(top+1);
    			sb.append("\n");
    			break;
    		case "4":
    			if(top < 0) sb.append(1);
    			else sb.append(0);
    			sb.append("\n");
    			break;
    		case "5":
    			if(top > -1) sb.append(st[top]);
    			else sb.append(-1);
    			sb.append("\n");
    			break;
    		}
    	}

    	System.out.println(sb.toString());
    }
}