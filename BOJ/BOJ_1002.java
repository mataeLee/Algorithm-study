import java.io.*;
import java.util.*;

public class Main {
    // 백준 기본수학2 터렛 - 1002
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            
            int subX = Math.abs(x2-x1);
            int subY = Math.abs(y2-y1);
            double distance = Math.sqrt(subX*subX + subY*subY);
            // 위치가 같은 경우
            if(distance == 0){
                if(r1 == r2){
                    System.out.println(-1);
                    continue;
                }
                else{
                    System.out.println(0);
                    continue;
                }
            }
            if(distance > r1 + r2){
                System.out.println(0);
                continue;
            }
            if(distance == r1 + r2){
                System.out.println(1);
                continue;
            }
            if(distance == Math.abs(r2-r1)){
                System.out.println(1);
                continue;
            }
            if(distance > Math.abs(r2-r1)){
                System.out.println(2);
                continue;
            }
            if(distance < Math.abs(r2-r1)){
                System.out.println(0);
            }
        }
    }
}