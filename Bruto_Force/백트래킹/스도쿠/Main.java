import java.io.*;
import java.util.*;

public class Main{
    // 백준 백트래킹 스도쿠 - 2580
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] map = new int[9][9];
        int blank = 0;
        for(int i=0; i<9; i++){
            String[] str = br.readLine().split(" ");
            for(int j=0; j<9; j++){
                map[i][j] = Integer.parseInt(str[j]);
                if(map[i][j] == 0) blank++;
            }
        }
        int[][] res = new int[blank][3];
        int idx = 0;
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(map[i][j] == 0) {
                    res[idx][0] = i;
                    res[idx][1] = j;
                    idx++;
                }
            }
        }
        backtracking(map,0, res);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map.length; j++){
                sb.append(map[i][j]);
                if(j<map.length-1) sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static boolean backtracking(int[][] map, int depth, int[][] res) {
        if(depth == res.length){
            return true;
        }
        int x = res[depth][0];
        int y = res[depth][1];
        for(int i=1; i<=9; i++){
            if(check(map, x, y, i)){
                map[x][y] = i;
                if(!backtracking(map,depth+1, res)) {
                    map[x][y] = 0;
                }else return true;
            }
        }
        return false;
    }

    public static boolean check(int[][] map, int x, int y, int val){
        //행체크
        for(int i=0; i<9; i++){
            if(map[x][i] == val) return false;
        }
        //열체크
        for(int i=0; i<9; i++){
            if(map[i][y] == val) return false;
        }
        //칸체크
        int startX = x-x%3;
        int startY = y-y%3;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(map[i+startX][j+startY] == val) return false;
            }
        }
        return true;
    }
}