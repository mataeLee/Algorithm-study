import java.io.*;
import java.util.*;

public class Main{
    // 백준 그리디 잃어버린 괄호 - 1541
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split("-");
        int res = 0;
        for(int i=0; i<strs.length; i++){
            String str = strs[i];
            int sum = 0;
            for(int j=0; j<str.length(); j++){
                char c = str.charAt(j);
                if(c == '+'){
                    sum += Integer.parseInt(str.substring(0,j));
                    str = str.substring(j+1);
                    j=0;
                }
            }
            sum += Integer.parseInt(str);
            if(i > 0){
                res -= sum;
            }else{
                res = sum;
            }
        }
        System.out.println(res);
    }
}