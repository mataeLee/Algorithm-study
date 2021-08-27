import java.util.*;

public class Main {
    // 백준 문자열 크로아티아 알파벳 - 2941
    public static void solution() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] arr = new String[8];
        arr[0] = "c=";
        arr[1] = "c-";
        arr[2] = "dz=";
        arr[3] = "d-";
        arr[4] = "lj";
        arr[5] = "nj";
        arr[6] = "s=";
        arr[7] = "z=";
        int cnt = 0;
        for(int i=0; i<8; i++){
            String element = arr[i];
            String gap = "";
            if(element.length() == 2) gap = "..";
            else if(element.length() == 3) gap = "...";

            while (str.indexOf(element) > -1){
                int idx = str.indexOf(element);
                str = str.substring(0, idx) + gap + str.substring(idx+element.length());
                cnt++;
            }
        }
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) != '.') cnt++;
        }
        System.out.println(cnt);
    }
    // result
    public static void main(String[] args) {
        solution();
    }
}