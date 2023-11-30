import java.io.*;
import java.util.*;

public class Main{
    // 백준 자료구조 문자열 폭발 - 9935
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	String line = br.readLine();
	String bomb = br.readLine();
	int bombLength = bomb.length();
		
	Stack<Character> st = new Stack<>();
		
	for(int i=0; i<line.length(); i++) {
		st.push(line.charAt(i));
			
		// 폭발 문자열과 길이가 같아지면 탐색 시작 
		if(st.size()>= bombLength) {
			boolean isBomb = true;
			
			for(int j=0; j<bombLength; j++) {
				if(st.get(st.size()-bombLength+j) != bomb.charAt(j)) {
					isBomb = false;
					break;
				}
			}
			if(isBomb) {
				for(int j=0; j<bombLength; j++) {
					st.pop();
				}
			}
		}
	}
		
	if(st.size() == 0) System.out.println("FRULA");
	else {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<st.size(); i++) sb.append(st.get(i));
		System.out.println(sb);
	}
    }
}
