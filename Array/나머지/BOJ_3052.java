import java.util.*;

public class Main {
    // 백준 1차원 배열 3052 나머지
    public static void solution(){
        int[] res = new int[43];

        Scanner scanner = new Scanner(System.in);
        for(int i=0; i<10; i++){
            int num = scanner.nextInt();
            res[num % 42]++;
        }
        int answer = 0;
        for(int i=0; i<res.length; i++){
            if(res[i] > 0) answer++;
        }
        System.out.println(answer);
    }
    // result
    public static void main(String[] args) {
        solution();
    }
}