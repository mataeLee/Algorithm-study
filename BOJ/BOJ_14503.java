import java.io.*;
import java.util.*;

public class Main {
    // 백준 구현 로봇 청소기 - 14503
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] size = br.readLine().split(" ");
        String[] info = br.readLine().split(" ");
        int x = Integer.parseInt(info[0]);
        int y = Integer.parseInt(info[1]);
        int current = Integer.parseInt(info[2]); // 0 1 2 3 북 동 남 서

        int[][] map = new int[Integer.parseInt(size[0])][Integer.parseInt(size[1])];

        for(int i=0; i<map.length; i++){
            String[] val = br.readLine().split(" ");
            for(int j=0; j<val.length; j++){
                map[i][j] = Integer.parseInt(val[j]);
            }
        }

        int answer = 0;

        while (true){
            if(map[x][y] == 0) {
                map[x][y] = 2;
                answer++;
            }

            // 4방향 검사
            int count = 0;
            for(int i=0; i<4; i++){
                current = (current+3)%4;
                x += dir[current][0];
                y += dir[current][1];
                if(map[x][y] == 0) break;
                x -= dir[current][0];
                y -= dir[current][1];
                count++;
            }

            // 4방향 청소 실패
            if(count == 4){
                current = (current+2)%4;
                x += dir[current][0];
                y += dir[current][1];
                if(map[x][y] == 1) {
                    System.out.println(answer);
                    return;
                }
                current = (current+2)%4;
            }
        }
    }
}