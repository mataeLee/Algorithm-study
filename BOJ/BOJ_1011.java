import java.io.*;
import java.util.*;

public class Main {
    // 백준 기본수학1 Fly me to the Alpha Centauri - 1011
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            double distance = Math.abs(Double.parseDouble(st.nextToken()) - Double.parseDouble(st.nextToken()));
            int cnt = 0;
            double front = 1;
            double rear = 1;
            while (distance>0){
                distance = distance - front - rear;
                if(distance>=0) cnt+=2;
                else {
                    if(distance + rear > 0) cnt+=2;
                    else cnt++;
                }
                front++;
                rear++;
            }
            System.out.println(cnt);
        }
    }
}