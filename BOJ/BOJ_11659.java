import java.io.*;
import java.util.*;

public class Main{
	// 백준 구간 합 구하기4 - 11659 실버3
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		String[] data = br.readLine().split(" ");
		int N = Integer.parseInt(data[0]);
		int M = Integer.parseInt(data[1]);
		
		int[] sumArr = new int[N];
		
		String[] numbers = br.readLine().split(" ");
		
		sumArr[0] = Integer.parseInt(numbers[0]);
		
		for(int i=1; i<N; i++) {
			sumArr[i] = sumArr[i - 1] + Integer.parseInt(numbers[i]);
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<M; i++) {
			String[] section = br.readLine().split(" ");
			int start = Integer.parseInt(section[0]) - 1;
			int end = Integer.parseInt(section[1]) - 1;
			
			if(start <= 0) {
				sb.append(sumArr[end]);
			}
			else {
				sb.append(sumArr[end] - sumArr[start - 1]);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
    }
}