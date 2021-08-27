import java.util.*;

public class Main {
    // 백준 문자열 문자열 반복 - 2675
    public static void solution() {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        for(int i=0; i<num; i++){
            int count = scanner.nextInt();
            String str = scanner.next();
            StringBuffer sb = new StringBuffer();
            for(int j=0; j<str.length(); j++){
                char c = str.charAt(j);
                for(int k=0; k<count; k++){
                    sb.append(c);
                }
            }
            System.out.println(sb.toString());
        }
    }
    // result
    public static void main(String[] args) {
        solution();
    }
}