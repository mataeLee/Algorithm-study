import java.util.*;

public class Main {
    // 백준 1차원 배열 1546 평균
    public static void solution(){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        double[] points = new double[num];
        double max = 0;
        for(int i=0; i<num; i++){
            points[i] = scanner.nextInt();
            if(points[i] > max) max = points[i];
        }

        double sum = 0;
        for(int i=0; i<num; i++){
            points[i] = points[i]/max * 100;
            sum += points[i];
        }

        System.out.println(sum/num);
    }
    // result
    public static void main(String[] args) {
        solution();
    }
}