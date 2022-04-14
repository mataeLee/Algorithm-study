import java.util.*;

public class Main {
    // 백준 1차원 배열 4344 평균은 넘겠지
    public static void solution(){
        Scanner scanner = new Scanner(System.in);
        int testcase = scanner.nextInt();

        for(int i=0; i<testcase; i++){
            int n = scanner.nextInt();
            int[] arr = new int[n];
            int sum = 0;
            for(int j=0; j<n; j++){
                arr[j] = scanner.nextInt();
                sum += arr[j];
            }
            int aver = sum/n;
            int cnt = 0;
            for(int j=0; j<n; j++){
                if(arr[j] > aver) cnt++;
            }

            System.out.println(String.format("%.3f", (double)cnt/n*100)+"%");
        }
    }
    // result
    public static void main(String[] args) {
        solution();
    }
}