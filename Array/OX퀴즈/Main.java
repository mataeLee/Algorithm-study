import java.util.*;

public class Main {
    // 백준 1차원 배열 8958 OX퀴즈
    public static void solution(){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        for(int i=0; i<num; i++){
            String ques = scanner.next();
            int res = 0;
            int cont = 0;
            for(int j=0; j<ques.length(); j++){
                switch (ques.charAt(j)){
                    case 'O':
                        res += 1;
                        res += cont;
                        cont++;
                        break;
                    case 'X':
                        cont = 0;
                        break;
                }
            }
            System.out.println(res);
        }
    }
    // result
    public static void main(String[] args) {
        solution();
    }
}