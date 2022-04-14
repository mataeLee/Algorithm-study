import java.util.*;

public class Main {
    // 백준 기본수학1 손익분기점 - 1712
    public static void solution() {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        if(b >= c) {
            System.out.println(-1);
            return;
        }
        System.out.println(a / (c-b) +1);

    }

    // result
    public static void main(String[] args) {
        solution();
    }
}