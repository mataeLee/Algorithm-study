import java.io.*;
import java.util.*;

public class Main {
    // 백준 자료구조 전화번호 목록 - 5052

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n; i++){
            int m = Integer.parseInt(br.readLine());
            String[] arr = new String[m];
            for(int j=0; j<m; j++){
                arr[j] = br.readLine().trim().replace(" ", "");
            }
            Arrays.sort(arr);
            boolean cons = false;
            if(arr.length == 1) {
            	sb.append("YES");
            	sb.append("\n");
            	continue;
            }
            for(int j=1; j<m; j++){
                String str = arr[j-1];
                if(arr[j].indexOf(str) == 0) {
                    sb.append("NO");
                    cons = true;
                    break;
                }
            }
            if(!cons) sb.append("YES");
            sb.append("\n");

        }
        System.out.println(sb);
    }
}
