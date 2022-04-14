import java.io.*;
import java.util.*;

public class Main{
    // 백준 그리디 주유소 - 13305
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] distance = br.readLine().split(" ");
        String[] costs = br.readLine().split(" ");
        long sum_dist = 0; // 이동거리
        long pay = 0; // 지불할 금액
        long min = Long.parseLong(costs[0]); // 지나온 도시까지 기름 최소값

        // 1. 이동
        // 2. 기름값 비교
        // 3. 도착한 도시가 더 저렴하다면 지금까지 온 거리 계산(이동거리 초기화)후 기름 최소값 초기화
        // 4. 기름값이 더 비싸면 이동
        for(int i=1; i<n; i++){
            sum_dist += Long.parseLong(distance[i-1]); // 이동
            long current = Long.parseLong(costs[i]);
            if(current < min){ // 기름값 비교 저렴할 경우
                pay += sum_dist*min; // 여태 온 거리 계산
                min = current; // 기름 최소값 초기화
                sum_dist = 0; // 이동거리 초기화
            }
        }
        pay += sum_dist*min; // 도착했으니 잔여 계산
        System.out.println(pay);
    }
}