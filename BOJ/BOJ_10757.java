import java.io.*;
import java.util.*;

public class Main {
    // 백준 기본수학1 큰수 A+B - 10757
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        String b = st.nextToken();
        StringBuilder sb = new StringBuilder();
        int len = (a.length() > b.length())? a.length():b.length();
        boolean fraction = false;
        int sum = 0;
        for(int i=0; i<len; i++){
            int a1 = 0;
            int b1 = 0;
            if(i<a.length())
                a1 = a.charAt(a.length()-1-i)-'0';
            if(i<b.length())
                b1 = b.charAt(b.length()-1-i)-'0';
            sum = a1 + b1;
            if(fraction) sum++;
            if(sum > 9){
                sb.insert(0, sum-10);
                fraction = true;
            }
            else{
                sb.insert(0,sum);
                fraction = false;
            }
        }
        if(fraction)
            sb.insert(0, 1);
        System.out.println(sb.toString());
    }
}