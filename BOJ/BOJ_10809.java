import java.util.*;

public class Main {
    // 백준 문자열 알파벳 찾기 - 10809
    public static void solution() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        for(int i=97; i<123; i++){
            System.out.println(str.indexOf(i));
        }
    }
    // result
    public static void main(String[] args) {
        solution();
    }
}