import java.io.*;
import java.util.*;

public class Main{
	// 백준 깊이우선탐색1 - 24479 실버2
    
	static int order = 1;
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	String[] data = br.readLine().split(" ");
    	
    	int N = Integer.parseInt(data[0]);
    	
    	// 간선 배열
    	PriorityQueue<Integer>[] edges = new PriorityQueue[N+1];
    	for(int i=1; i<N+1; i++) {
    		edges[i] = new PriorityQueue<>();
    	}
    	
    	int M = Integer.parseInt(data[1]);
    	
    	int R = Integer.parseInt(data[2]);
    	
    	for(int i=0; i<M; i++) {
    		String[] edge = br.readLine().split(" ");
    		edges[Integer.parseInt(edge[0])].add(Integer.parseInt(edge[1]));
    		edges[Integer.parseInt(edge[1])].add(Integer.parseInt(edge[0]));
    	}
    	
    	int[] visited = new int[N+1];
    	
    	dfs(R, edges, visited);
    	
    	StringBuilder sb = new StringBuilder();
    	for(int i=1; i<N+1; i++) {
    		sb.append(visited[i]).append("\n");
    	}
    	
    	System.out.println(sb.toString());
    }
	
	static void dfs(int vertex, PriorityQueue<Integer>[] edges , int[] visited) {
		visited[vertex] = order++;
		
		while(edges[vertex].size() > 0) {
			int adjVertex = edges[vertex].poll();
			if(visited[adjVertex] == 0)
				dfs(adjVertex, edges, visited);
		}
	}
}