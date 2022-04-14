import java.util.*;

public class Main {
    // 백준 문자열 상수 - 2908
    public static void solution() {
        Scanner scanner = new Scanner(System.in);
        StringBuffer a = new StringBuffer(scanner.next());
        StringBuffer b = new StringBuffer(scanner.next());
        a.reverse();
        b.reverse();

        String res = (Integer.parseInt(a.toString()) > Integer.parseInt(b.toString()))?a.toString():b.toString();
        System.out.println(res);
    }
    // result
    public static void main(String[] args) {
        solution();
    }
}