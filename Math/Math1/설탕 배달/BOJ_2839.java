import java.io.*;
import java.util.*;

public class Main {
    // 백준 기본수학1 설탕 배달 - 2839
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int kg = Integer.parseInt(br.readLine());
        int five = 0;
        // 5KG을 최대한 넣고 하나씩 빼면서 3KG으로 조율
        five = kg/5;
        kg = kg%5;
        while (five > -1){
            if(kg%5 == 0){
                System.out.println(five);
                return;
            }
            if(kg%3 == 0){
                System.out.println(five + (kg/3));
                return;
            }
            five--;
            kg+=5;
        }
        System.out.println(-1);
    }
}