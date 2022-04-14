import java.io.*;
import java.util.*;

public class Main{
    // 백준 그리디 회의실 배정 - 1931
    static class Meeting implements Comparable<Meeting>{
        int start;
        int end;
        Meeting(int start, int end){
            this.start = start;
            this.end = end;
        }
        public int compareTo(Meeting m) {
            if(this.end == m.end) return this.start - m.start;
            return this.end - m.end;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Meeting[] meetings = new Meeting[n];
        for(int i=0; i<n; i++){
            String[] strs = br.readLine().split(" ");
            meetings[i] = new Meeting(Integer.parseInt(strs[0]),Integer.parseInt(strs[1]));
        }
        Arrays.sort(meetings);
        int cnt = 0;
        int current = 0;
        for(int i=0; i<n; i++){
            if(meetings[i].start >= current) {
                cnt++;
                current = meetings[i].end;
            }
        }
        System.out.println(cnt);
    }
}