import java.util.*;

public class Main {
    // 백준 1차원 배열 2577 숫자의 갯수
    public static void solution(){
        int[] res = new int[10];

        int a, b, c;
        Scanner scanner = new Scanner(System.in);
        a = scanner.nextInt();
        b = scanner.nextInt();
        c = scanner.nextInt();

        StringBuilder sum = new StringBuilder();
        sum.append(a*b*c);

        for(int i=0; i<sum.length(); i++){
            res[sum.charAt(i)-'0']++;
        }

        for(int i=0; i<res.length; i++){
            System.out.println(res[i]);
        }
    }
    // result
    public static void main(String[] args) {
        solution();
    }
}