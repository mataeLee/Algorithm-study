import java.util.*;

public class Main {
    // 백준 문자열 숫자의 합
    public static void solution() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String str = scanner.next();
        int sum = 0;
        for(int i=0; i<str.length(); i++){
            sum += str.charAt(i)-'0';
        }
        System.out.println(sum);
    }
    // result
    public static void main(String[] args) {
        solution();
    }
}