import java.util.*;

public class Main {
    // 백준 문자열 그룹 단어 체커 - 1316
    public static void solution() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int cnt = 0;
        for(int i=0; i<n; i++){
            String str = scanner.next();
            if(check(str)) cnt++;
        }
        System.out.println(cnt);
    }
    static boolean check(String str){
        Map<Character, Integer> map = new HashMap<>();

        for(int j=0; j<str.length(); j++){
            char c = str.charAt(j);
            if(map.containsKey(c)){
                int idx = map.get(c);
                if(idx != j-1) return false;
                map.put(c, j);
            }
            else{
                map.put(c, j);
            }
        }
        return true;
    }

    // result
    public static void main(String[] args) {
        solution();
    }
}