import java.util.*;

public class Main {
    // 백준 문자열 단어공부 - 1157
    public static void solution() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int[] arr = new int[91];
        for(int i=0; i<str.length(); i++){
            arr[Character.toUpperCase(str.charAt(i))]++;
        }
        int max = 0;
        int idx = 0;
        boolean duplicated = false;
        for(int i=65; i<arr.length; i++){
            if(arr[i] > max) {
                max = arr[i];
                idx = i;
                duplicated = false;
            }
            else if(arr[i] == max) duplicated = true;
        }
        if(duplicated){
            System.out.println("?");
            return;
        }
        System.out.println((char)idx);
    }
    // result
    public static void main(String[] args) {
        solution();
    }
}