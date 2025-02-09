import java.io.*;
import java.util.*;

class Main{
    // 백준 합 - 1081
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data = br.readLine().split(" ");

        int L = Integer.parseInt(data[0]) - 1;
        int U = Integer.parseInt(data[1]);

        long answer = 0;
        
        long[] countMap = new long[10];

        for(int i=1; i<10; i++){
            countMap[i] = (long) (45 * Math.pow(10, i - 1) + countMap[i - 1] * 10);
        }

        int[] count = new int[10];

        while(U > 0){
            if(U < 10){
                count[U--]++;
                continue;
            }
            int pow = (int) Math.log10(U);
            int digit = (int) Math.pow(10, pow);
            int val = U / digit;

            long remain = U - digit * val;
            count[val] = count[val] + (int)remain + 1;

            answer += (countMap[pow] * val);

            for(int i=1; i<val; i++){
                count[i] += digit;
            }

            U = U - (digit * val);
        }

        int[] count2 = new int[10];

        while(L > 0){
            if(L < 10){
                count2[L--]++;
                continue;
            }
            int pow = (int) Math.log10(L);
            int digit = (int) Math.pow(10, pow);
            int val = L / digit;

            long remain = L - digit * val;

            count2[val] = count2[val] + (int)remain + 1;

            answer -= (countMap[pow] * val);

            for(int i=1; i<val; i++){
                count2[i] += digit;
            }

            L = L - (digit * val);
        }

        for(int i=1; i<10; i++){
            answer += (count[i] - count2[i]) * i;
        }

        System.out.println(answer);
    }
}