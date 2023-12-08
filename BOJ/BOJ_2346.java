import java.io.*;
import java.util.*;

public class Main{
	// 백준 풍선 터뜨리기 - 2346 실버3
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int n = Integer.parseInt(br.readLine());
    	
    	int[] balloons = new int[n+1];
    	
    	String[] paperData = br.readLine().split(" ");
    	for(int i=1; i<=n; i++) {
    		balloons[i] = Integer.parseInt(paperData[i-1]);
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	Deque<Integer> dq = new ArrayDeque<>();
    	
    	for(int i=0; i<n; i++) {
    		dq.add(i+1);
    	}
    	int balloon = dq.pollFirst();
    	sb.append(balloon).append(" ");
    	int paper = balloons[balloon];
    	while(dq.size() > 0) {
    		if(paper > 0) {
    			for(int i=0; i<paper; i++) dq.addLast(dq.pollFirst());
    			balloon = dq.pollLast();
        		sb.append(balloon).append(" ");
            	paper = balloons[balloon];
    		}
    		else {
    			for(int i=0; i<Math.abs(paper); i++) dq.addFirst(dq.pollLast());
    			balloon = dq.pollFirst();
        		sb.append(balloon).append(" ");
            	paper = balloons[balloon];
    		}
    	}
    	System.out.println(sb.toString());
    }
}