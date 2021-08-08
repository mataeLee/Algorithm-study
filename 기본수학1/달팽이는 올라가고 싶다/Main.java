import java.io.*;
import java.util.*;

public class Main {
    // 백준 기본수학1 달팽이는 올라가고 싶다 - 2869
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double a = Double.parseDouble(st.nextToken());
        double b = Double.parseDouble(st.nextToken());
        double v = Double.parseDouble(st.nextToken()) - a;
        if(v % (a-b) == 0){
            System.out.println((int)(v/(a-b)) + 1);
        }
        else{
            System.out.println((int)(v/(a-b)) + 2);
        }
    }
}