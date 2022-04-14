import java.util.*;

public class Main {
    // 백준 기본수학1 벌집 - 2292
    public static void solution() {
        Scanner scanner = new Scanner(System.in);
        double n = scanner.nextInt();
        if(n == 1) {
            System.out.println(1);
            return;
        }
        int cnt = 1;
        double sum = 1;
        while (sum < n){
            sum += cnt*6;
            cnt++;
        }
        System.out.println(cnt);
    }

    // result
    public static void main(String[] args) {
        solution();
    }
}