import java.util.*;

public class Main {
    // 백준 문자열 단어의 개수 - 1152
    public static void solution() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().trim();
        if(str.length() < 1) {
            System.out.println("0");
            return;
        }
        String[] arr = str.split(" ");
        System.out.println(arr.length);
    }

    // result
    public static void main(String[] args) {
        solution();
    }
}