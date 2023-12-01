import java.io.*;
import java.util.*;

public class Main{
	// 백준 도키도키 간식드리미 - 12789 실버2
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int n = Integer.parseInt(br.readLine());
    	
    	int[] st1 = new int[n];
    	int[] st2 = new int[n];
    	int top1 = -1;
    	int top2 = -1;

    	String[] data = br.readLine().split(" ");
    	for(int i=0; i<n; i++) {
    		st1[n-i-1] = Integer.parseInt(data[i]);
    		++top1;
    	}

    	int order = 1;
    	boolean isContinue = false;
    	
    	while(order != n) {
    		if(top1 > -1 && top2 > -1) {
    			if(st1[top1] == order) {
    				order++;
    				top1--;
    				isContinue = false;
        			continue;
    			}
    			if(st2[top2] == order) {
    				order++;
    				isContinue = false;
    				top2--;
    				continue;
    			}
    			
    		}
    		
    		if(top1 > -1) {
    			if(st1[top1] == order) {
    				order++;
    				top1--;
    				isContinue = false;
    				continue;
    			}
    			else {
    				st2[++top2] = st1[top1--];
    				
    				if(top1 < 0 && !isContinue) isContinue = true;
    				else if(top1 < 0 && isContinue) {
    					System.out.println("Sad");
    					return;
    				}
    				continue;
    			}
    		}
    		if(top2 > -1) {
    			if(st2[top2] == order) {
    				order++;
    				top2--;
    				isContinue = false;
    				continue;
    			}
    			else {
    				st1[++top1] = st2[top2--];
    				if(top2 < 0 && !isContinue) isContinue = true;
    				else if(top2 < 0 && isContinue) {
    					System.out.println("Sad");
    					return;
    				}
    				continue;
    			}
    		}
    		
    	}
    	System.out.println("Nice");
    }
}