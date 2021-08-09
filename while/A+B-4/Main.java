import java.io.*;
import java.util.*;

public class Main {
    // 백준 while문 A+B-4 - 10951
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String str = br.readLine();
            if(str == null) return;
            String[] arr = str.split(" ");
            System.out.println(Integer.parseInt(arr[0]) + Integer.parseInt(arr[1]));
        }
    }
}