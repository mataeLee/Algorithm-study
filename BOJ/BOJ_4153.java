import java.io.*;
import java.util.*;

public class Main {
    // 백준 기본수학2 직각삼각형 - 4153
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[3];
        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[0] = Integer.parseInt(st.nextToken());
            if(arr[0]==0) break;
            arr[1] = Integer.parseInt(st.nextToken());
            arr[2] = Integer.parseInt(st.nextToken());
            Arrays.sort(arr);
            if(arr[0]*arr[0]+arr[1]*arr[1]==arr[2]*arr[2]){
                System.out.println("right");
            }
            else
                System.out.println("wrong");
        }
    }
}