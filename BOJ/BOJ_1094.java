import java.io.*;
import java.util.*;

public class Main {
    // 백준 비트마스크 막대기 - 1094

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());
        int count = 0;

        int stick = 64;

        while (X > 0){
            stick /= 2;
            if(stick <= X){
                X -= stick;
                count++;
            }
        }

        System.out.println(count);
    }
}