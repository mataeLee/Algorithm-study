import java.io.*;
import java.util.*;

public class Main {
    // 백준 기본수학1 ACM 호텔 - 10250
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            st.nextToken();
            int turn = Integer.parseInt(st.nextToken());
            if(turn%h == 0){
                System.out.println(h+String.format("%02d", turn/h));
            }
            else{
                System.out.println(turn%h + String.format("%02d",turn/h+1));
            }
        }
    }
}