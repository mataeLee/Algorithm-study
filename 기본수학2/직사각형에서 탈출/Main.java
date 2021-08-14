import java.io.*;
import java.util.*;

public class Main {
    // 백준 기본수학2 직사각형에서 탈출 - 1085
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        if(x > w && y > h) {
            System.out.println(x - w + y - h);
            return;
        }
        int arr[] = new int[4];
        arr[0] = Math.abs(x-w);
        arr[1] = x;
        arr[2] = Math.abs(y-h);
        arr[3] = y;
        Arrays.sort(arr);
        System.out.println(arr[0]);
    }
}