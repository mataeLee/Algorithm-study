import java.io.*;
import java.util.*;

public class Main{
    // 백준 자료구조 에디터 - 1406
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Character> left = new LinkedList<>();
        Deque<Character> right = new LinkedList<>();
        String str = br.readLine();
        for(int i=0; i<str.length(); i++){
            left.add(str.charAt(i));
        }
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            String[] strs = br.readLine().split(" ");
            switch (strs[0]){
                case "P":
                    left.add(strs[1].charAt(0));
                    break;
                case "L":
                    if(left.size() > 0) {
                        right.addFirst(left.pollLast());
                    }
                    break;
                case "D":
                    if(right.size() > 0) {
                        left.addLast(right.pollFirst());
                    }
                    break;
                case "B":
                    if(left.size() > 0){
                        left.pollLast();
                    }
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (left.size() > 0){
            sb.append(left.pollFirst());
        }
        while (right.size() > 0){
            sb.append(right.pollFirst());
        }
        System.out.println(sb);
    }
}