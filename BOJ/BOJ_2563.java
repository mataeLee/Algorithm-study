import java.io.*;
import java.util.*;

public class Main{
	// 백준 색종이 - 2563 실버5
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
    	boolean[][] map = new boolean[100][100];
    	
    	int n = Integer.parseInt(br.readLine());
    	int answer = 0;
    	for(int i=0; i<n; i++) {
    		String[] point = br.readLine().split(" ");
    		int x = Integer.parseInt(point[0]) - 1;
    		int y = Integer.parseInt(point[1]) - 1;
    		
    		for(int j=0; j<10; j++) {
    			for(int k=0; k<10; k++) {
    				if(map[j+x][k+y]) continue;
    				map[j+x][k+y] = true;
    				answer++;
    			}
    		}
    	}
    	
    	System.out.println(answer);
    }
}