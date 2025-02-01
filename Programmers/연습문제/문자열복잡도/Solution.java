import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.*;

public class Solution {
    // 문자열 복잡도

    static class Point{
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    public static int MOD = 1000007;
    public static Map<String, Integer> memo = new HashMap<>();
    public static char[][] keyboard = {{'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o'},
                                       {'p', 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k'},
                                       {'l', 'z', 'x', 'c', 'v', 'b', 'n', 'm', ' '}};
    public static Map<Character, Point> keyPointMap = new HashMap<>();

    // algorithm solution
    public int solution(String data) {
        if(data.length()< 2) return 0;

        for(int i=0; i<keyboard.length; i++){
            for(int j=0; j<keyboard[i].length; j++){
                keyPointMap.put(keyboard[i][j], new Point(i, j));
            }
        }

        int n = data.length();
        int answer = 0;

        for (int i = 0; i < n - 1; i++) {
            Point p1 = keyPointMap.get(data.charAt(i));
            Point p2 = keyPointMap.get(data.charAt(i+1));
            int distance = (Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y))%MOD;
            int sum = (distance * (i + 1) * (n - i - 1))%MOD; // 문자의 기여도 계산
            answer = (answer + sum) % MOD; // 총 가중치 누적
        }

        return answer;
    }

    // result
    public static void main(String[] args) {
        Solution main = new Solution();

        // test case
        long setInputStartTime = System.nanoTime();
        makeTestCase();
        String testcase = getTestCase();
        long setInputEndTime = System.nanoTime();
        System.out.println("Set Input Time: " + (setInputEndTime - setInputStartTime) / 1_000_000.0 + " ms");

        // run time
        long startTime = System.nanoTime();
        int answer = main.solution(testcase);
        long endTime = System.nanoTime();
        System.out.println("Execution Time: " + (endTime - startTime) / 1_000_000.0 + " ms");

        System.out.println(answer);
    }

    // test case
    public static void makeTestCase(){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("testcase.txt");
            String data = "abbc";
            byte b[] = data.getBytes();
            for(int i=0; i<100000; i++)
                fileOutputStream.write(b);
            fileOutputStream.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static String getTestCase(){
        try{
            FileInputStream fileInputStream = new FileInputStream("testcase.txt");
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            int i = 0;
            StringBuilder sb = new StringBuilder();
            while ((i = bufferedInputStream.read()) != -1){
                sb.append((char)i);
            }
            fileInputStream.close();
            return sb.toString();
        }catch (Exception e) {
            System.out.println(e);
        }
        return "";
    }
}